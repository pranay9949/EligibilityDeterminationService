package com.example.EligibilityDeterminationService.dto;


import lombok.Data;

@Data
public class PlanRequest {

    private String planName;
    private Long caseNumber;

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Long getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(Long caseNumber) {
        this.caseNumber = caseNumber;
    }
}
