package com.example.EligibilityDeterminationService.dto;


import lombok.Data;

@Data
public class ChildrenRequest {



    private String childName;


    private Integer childAge;



    private Long childSsn;

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public Integer getChildAge() {
        return childAge;
    }

    public void setChildAge(Integer childAge) {
        this.childAge = childAge;
    }

    public Long getChildSsn() {
        return childSsn;
    }

    public void setChildSsn(Long childSsn) {
        this.childSsn = childSsn;
    }
}
