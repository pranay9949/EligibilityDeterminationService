package com.example.EligibilityDeterminationService.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Data
public class EligibilityDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer edTraceId;

    @Column(name="CASE_NUMBER")
    private Long caseNumber;

    @Column(name="HOLDER_NAME")
    private String holderName;

    @Column(name="HOLDER_SSN")
    private Long holderSsn;

    @Column(name="PLAN_NAME")
    private String planName;

    @Column(name="PLAN_STATUS")
    private  String planStatus;

    @Column(name="PLAN_START_DATE")
    private LocalDate planStartDate;

    @Column(name="PLAN_END_DATE")
    private LocalDate planEndDate;

    @Column(name="BENEFIT_AMOUNT")
    private Double benefitAmount;

    @Column(name="DENIAL_REASON")
    private String denialReason;

    @Column(name="CREATED_AT",updatable = false)
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name="UPDATED_AT",insertable = false)
    @UpdateTimestamp
    private LocalDate updatedAt;

    public Integer getEdTraceId() {
        return edTraceId;
    }

    public void setEdTraceId(Integer edTraceId) {
        this.edTraceId = edTraceId;
    }

    public Long getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(Long caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public Long getHolderSsn() {
        return holderSsn;
    }

    public void setHolderSsn(Long holderSsn) {
        this.holderSsn = holderSsn;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }

    public LocalDate getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(LocalDate planStartDate) {
        this.planStartDate = planStartDate;
    }

    public LocalDate getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(LocalDate planEndDate) {
        this.planEndDate = planEndDate;
    }

    public Double getBenefitAmount() {
        return benefitAmount;
    }

    public void setBenefitAmount(Double benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public String getDenialReason() {
        return denialReason;
    }

    public void setDenialReason(String denialReason) {
        this.denialReason = denialReason;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
