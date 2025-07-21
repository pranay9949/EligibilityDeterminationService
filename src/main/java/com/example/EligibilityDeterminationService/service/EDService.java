package com.example.EligibilityDeterminationService.service;

import com.example.EligibilityDeterminationService.dto.EligibilityResponse;
import com.example.EligibilityDeterminationService.dto.SummaryResponse;
import com.example.EligibilityDeterminationService.exception.CaseNumNotFoundException;

public interface EDService {

    public EligibilityResponse determineEligibility(Long CaseNum) throws CaseNumNotFoundException;
}
