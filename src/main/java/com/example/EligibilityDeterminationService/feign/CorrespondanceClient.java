package com.example.EligibilityDeterminationService.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="CORRESPODENCEDATASERVICE", url ="http://localhost:7006/api/correspondence")
public interface CorrespondanceClient {

    @PostMapping("/save/{caseNum}")
    public ResponseEntity<String> saveTriggerData(@PathVariable Long caseNum);
}
