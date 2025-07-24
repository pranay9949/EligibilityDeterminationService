package com.example.EligibilityDeterminationService.repo;

import com.example.EligibilityDeterminationService.entity.EligibilityDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EligibilityRepo extends JpaRepository<EligibilityDetails,Integer> {
    public EligibilityDetails findByCaseNumber(Long caseNum);

   public Boolean existsByCaseNumber(Long caseNum);

   public List<EligibilityDetails> findAllByCaseNumberIn(List<Long> caseNum);
}
