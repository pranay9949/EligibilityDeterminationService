package com.example.EligibilityDeterminationService.dto;

import lombok.Data;

@Data
public class IncomeRequest {



    private Double monthlyIncome;


    private Double rentalIncome;


    private Double propertyIncome;


    private Long caseNumber;

    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public Double getRentalIncome() {
        return rentalIncome;
    }

    public void setRentalIncome(Double rentalIncome) {
        this.rentalIncome = rentalIncome;
    }

    public Double getPropertyIncome() {
        return propertyIncome;
    }

    public void setPropertyIncome(Double propertyIncome) {
        this.propertyIncome = propertyIncome;
    }

    public Long getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(Long caseNumber) {
        this.caseNumber = caseNumber;
    }
}
