package com.example.EligibilityDeterminationService.controller;


import com.example.EligibilityDeterminationService.dto.EligibilityResponse;
import com.example.EligibilityDeterminationService.dto.SummaryResponse;
import com.example.EligibilityDeterminationService.exception.CaseNumNotFoundException;
import com.example.EligibilityDeterminationService.service.EDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/eligibility")
public class EDController {

    private EDService service;

    public EDController(EDService service) {
        this.service = service;
    }

    @GetMapping("/get/{caseNum}")
    public ResponseEntity<EligibilityResponse> get(@PathVariable Long caseNum) throws CaseNumNotFoundException {
        EligibilityResponse res = service.determineEligibility(caseNum);
        return  new ResponseEntity<>(res, HttpStatus.OK);
    }
}
