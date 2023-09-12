package com.wellsfargo.lms.repository;

import com.wellsfargo.lms.model.LoanCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanCardRepository extends JpaRepository<LoanCard, String> {
}
