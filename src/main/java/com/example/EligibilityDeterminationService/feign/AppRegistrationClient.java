package com.example.EligibilityDeterminationService.feign;


import com.example.EligibilityDeterminationService.dto.UserRegisteredSsnResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="APPLICATIONREGISTRATIONSERVICE",url="http://localhost:7003/api/registration")
public interface AppRegistrationClient {

    @GetMapping("/get/appid/{appId}")
    public ResponseEntity<UserRegisteredSsnResponse> getUserBySsn(@PathVariable Integer appId);
}
