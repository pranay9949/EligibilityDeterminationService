package com.example.EligibilityDeterminationService.controller;


import com.example.EligibilityDeterminationService.dto.EligibilityResponse;
import com.example.EligibilityDeterminationService.dto.SummaryResponse;
import com.example.EligibilityDeterminationService.exception.CaseNumAlreadyExistException;
import com.example.EligibilityDeterminationService.exception.CaseNumNotFoundException;
import com.example.EligibilityDeterminationService.service.EDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eligibility")
public class EDController {

    private EDService service;

    public EDController(EDService service) {
        this.service = service;
    }

    @PostMapping("/save/{caseNum}")
    public ResponseEntity<EligibilityResponse> add(@PathVariable Long caseNum) throws CaseNumNotFoundException, CaseNumAlreadyExistException {
        EligibilityResponse res = service.determineEligibility(caseNum);
        return  new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/get/{caseNum}")
    public ResponseEntity<EligibilityResponse> get(@PathVariable Long caseNum) throws CaseNumNotFoundException {
        EligibilityResponse res = service.getEligibilityRes(caseNum);
        return  new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<EligibilityResponse>> get(@RequestBody List<Long> caseNum) throws CaseNumNotFoundException {
        List<EligibilityResponse> res = service.getAllUsers(caseNum);
        return  new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/getAllbenefits")
    public ResponseEntity<List<EligibilityResponse>> getAll() throws CaseNumNotFoundException {
        List<EligibilityResponse> res = service.getAllBenefits();
        return  new ResponseEntity<>(res, HttpStatus.OK);
    }

}
