package com.example.EligibilityDeterminationService.feign;


import com.example.EligibilityDeterminationService.dto.SummaryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="DATACOLLECTIONSERVICE" ,url="http://localhost:7004/api/summary")
public interface DataCollectionClient {

    @GetMapping("/get/{caseNumber}")
    public ResponseEntity<SummaryResponse> getAllSavedData(@PathVariable Long caseNumber);

}
