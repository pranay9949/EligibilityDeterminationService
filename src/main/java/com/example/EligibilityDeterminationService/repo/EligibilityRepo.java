package com.example.EligibilityDeterminationService.repo;

import com.example.EligibilityDeterminationService.entity.EligibilityDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EligibilityRepo extends JpaRepository<EligibilityDetails,Integer> {
}
