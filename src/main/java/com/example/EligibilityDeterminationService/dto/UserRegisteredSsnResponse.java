package com.example.EligibilityDeterminationService.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRegisteredSsnResponse {
    //private String citizenState;
    private Long Ssn;
    private LocalDate dateOfBirth;
    private String  userName;
    private String emailId;

    public Long getSsn() {
        return Ssn;
    }

    public void setSsn(Long ssn) {
        Ssn = ssn;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
