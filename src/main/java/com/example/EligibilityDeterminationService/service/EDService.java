package com.example.EligibilityDeterminationService.service;

import com.example.EligibilityDeterminationService.dto.EligibilityResponse;
import com.example.EligibilityDeterminationService.dto.SummaryResponse;
import com.example.EligibilityDeterminationService.exception.CaseNumAlreadyExistException;
import com.example.EligibilityDeterminationService.exception.CaseNumNotFoundException;

import java.util.List;

public interface EDService {

    public EligibilityResponse determineEligibility(Long CaseNum) throws CaseNumNotFoundException, CaseNumAlreadyExistException;
    public EligibilityResponse getEligibilityRes(Long caseNum) throws CaseNumNotFoundException;

    public List<EligibilityResponse> getAllUsers(List<Long> caseNum);
    public List<EligibilityResponse> getAllBenefits();

}
