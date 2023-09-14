package com.wellsfargo.lms.repository;

import com.wellsfargo.lms.model.EmployeeIssueDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeIssueDetailsRepository extends JpaRepository<EmployeeIssueDetails,String> {
}
