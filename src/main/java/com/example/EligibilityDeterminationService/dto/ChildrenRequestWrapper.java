package com.example.EligibilityDeterminationService.dto;


import lombok.Data;

import java.util.List;

@Data
public class ChildrenRequestWrapper {
    private Long caseNumber;
    private List<ChildrenRequest> childrenRequests;

    public Long getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(Long caseNumber) {
        this.caseNumber = caseNumber;
    }

    public List<ChildrenRequest> getChildrenRequests() {
        return childrenRequests;
    }

    public void setChildrenRequests(List<ChildrenRequest> childrenRequests) {
        this.childrenRequests = childrenRequests;
    }
}
