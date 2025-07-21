package com.example.EligibilityDeterminationService.service;

import com.example.EligibilityDeterminationService.constants.AppConstants;
import com.example.EligibilityDeterminationService.dto.ChildrenRequest;
import com.example.EligibilityDeterminationService.dto.EligibilityResponse;
import com.example.EligibilityDeterminationService.dto.SummaryResponse;
import com.example.EligibilityDeterminationService.dto.UserRegisteredSsnResponse;
import com.example.EligibilityDeterminationService.entity.EligibilityDetails;
import com.example.EligibilityDeterminationService.exception.CaseNumNotFoundException;
import com.example.EligibilityDeterminationService.feign.AppRegistrationClient;
import com.example.EligibilityDeterminationService.feign.DataCollectionClient;
import com.example.EligibilityDeterminationService.repo.EligibilityRepo;
import feign.FeignException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;


@Service
public class EDServiceImpl implements EDService {

    private DataCollectionClient dataCollectionClient;
    private AppRegistrationClient registrationClient;
    private EligibilityRepo eligibilityRepo;


    public EDServiceImpl(DataCollectionClient dataCollectionClient, AppRegistrationClient registrationClient, EligibilityRepo eligibilityRepo) {
        this.dataCollectionClient = dataCollectionClient;
        this.registrationClient = registrationClient;
        this.eligibilityRepo = eligibilityRepo;

    }

    @Override
    public EligibilityResponse determineEligibility(Long caseNum) throws CaseNumNotFoundException {
        SummaryResponse res;


        try {
            res = dataCollectionClient.getAllSavedData(caseNum).getBody();

            // Process successful response
        } catch (FeignException.BadRequest e) {
            // Handle 400 Bad Request specifically

            throw new CaseNumNotFoundException("Invalid request: " + e.contentUTF8());
        } catch (Exception e) {
            // Handle other unexpected errors

            throw new IllegalArgumentException("Unexpected error");
        }


        EligibilityResponse response = checkAndExcuteEligibity(res);
        response.setCaseNumber(caseNum);
        System.out.println(response.getHolderSsn());

        EligibilityDetails details = new EligibilityDetails();

        BeanUtils.copyProperties(response, details);
        System.out.println(details.getHolderSsn());
        eligibilityRepo.save(details);
        return response;


    }

    public EligibilityResponse checkAndExcuteEligibity(SummaryResponse res) {
        EligibilityResponse response = new EligibilityResponse();
        UserRegisteredSsnResponse registeredSsnResponse = registrationClient.getUserBySsn(res.getAppId()).getBody();

        if (res.getPlanRequest().getPlanName().equals("SNAP")) {
            Double income = res.getIncomeRequest().getMonthlyIncome();
            if (income <= 300) {
                response.setPlanStatus(AppConstants.STATUS_APPROVED);
            } else {
                response.setPlanStatus(AppConstants.STATUS_DENIED);
                response.setDenialReason("Income Greater Than Eligibility");
            }
        } else if (res.getPlanRequest().getPlanName().equals("CCAP")) {
            Double income = res.getIncomeRequest().getMonthlyIncome();
            long childCount = 0L;
            if (res != null
                    && res.getChildrenRequestWrapper() != null
                    && res.getChildrenRequestWrapper().getChildrenRequests() != null) {
                childCount = res.getChildrenRequestWrapper()
                        .getChildrenRequests()
                        .size(); // or .stream().count()
            }
            List<ChildrenRequest> childrenRequests = res.getChildrenRequestWrapper().getChildrenRequests();

            if (income <= 300 && childCount > 0 && checkChildAge(childrenRequests)) {
                response.setPlanStatus(AppConstants.STATUS_APPROVED);
            } else {
                response.setPlanStatus(AppConstants.STATUS_DENIED);
                response.setDenialReason("Not Satisfied Bussines Rules");
            }
        } else if (res.getPlanRequest().getPlanName().equals("MEDICAID")) {
            Double income = res.getIncomeRequest().getMonthlyIncome();
            Double propertyIncome = res.getIncomeRequest().getPropertyIncome();

            if (income <= 300 && propertyIncome == 0) {
                response.setPlanStatus(AppConstants.STATUS_APPROVED);
            } else {
                response.setPlanStatus(AppConstants.STATUS_DENIED);
                response.setDenialReason("Income Greater Than Eligibility");
            }
        } else if (res.getPlanRequest().getPlanName().equals("MEDICARE")) {
            Integer age = Period.between(registeredSsnResponse.getDateOfBirth(), LocalDate.now()).getYears();
            if (age >= 65) {
                response.setPlanStatus(AppConstants.STATUS_APPROVED);
            } else {
                response.setPlanStatus(AppConstants.STATUS_DENIED);
                response.setDenialReason("Age Less Than Eligibility");
            }
        } else if (res.getPlanRequest().getPlanName().equals("NJW")) {
            Integer gradYear = res.getEducationRequest().getGraduationYear();
            if (gradYear < LocalDate.now().getYear() && res.getIncomeRequest().getMonthlyIncome() <= 0) {

                response.setPlanStatus(AppConstants.STATUS_APPROVED);
            } else {
                response.setPlanStatus(AppConstants.STATUS_DENIED);
                response.setDenialReason("Income Greater Than Eligibility");
            }
        }
        System.out.println(registeredSsnResponse.getDateOfBirth());
        System.out.println(registeredSsnResponse.getUserName());


        response.setPlanName(res.getPlanRequest().getPlanName());
        response.setHolderName(registeredSsnResponse.getUserName());
        response.setHolderSsn(registeredSsnResponse.getSsn());

        if (response.getPlanStatus() == AppConstants.STATUS_APPROVED) {

            response.setPlanStartDate(LocalDate.now());
            response.setPlanEndDate(LocalDate.now().plusMonths(6));
            response.setBenefitAmount(350.00);
        }


        return response;
    }


    public Boolean checkChildAge(List<ChildrenRequest> requests) {


        for (ChildrenRequest r : requests) {
            if (r.getChildAge() > 16) {
                return false;

            }
        }
        return true;
    }

}


