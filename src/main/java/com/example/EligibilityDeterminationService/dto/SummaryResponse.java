package com.example.EligibilityDeterminationService.dto;

import lombok.Data;

@Data
public class SummaryResponse {
    private Integer appId;
    private PlanRequest planRequest;
    private IncomeRequest incomeRequest;
    private EducationRequest educationRequest;
    private ChildrenRequestWrapper childrenRequestWrapper;

    public PlanRequest getPlanRequest() {
        return planRequest;
    }

    public void setPlanRequest(PlanRequest planRequest) {
        this.planRequest = planRequest;
    }

    public IncomeRequest getIncomeRequest() {
        return incomeRequest;
    }

    public void setIncomeRequest(IncomeRequest incomeRequest) {
        this.incomeRequest = incomeRequest;
    }

    public EducationRequest getEducationRequest() {
        return educationRequest;
    }

    public void setEducationRequest(EducationRequest educationRequest) {
        this.educationRequest = educationRequest;
    }

    public ChildrenRequestWrapper getChildrenRequestWrapper() {
        return childrenRequestWrapper;
    }

    public void setChildrenRequestWrapper(ChildrenRequestWrapper childrenRequestWrapper) {
        this.childrenRequestWrapper = childrenRequestWrapper;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }
}
