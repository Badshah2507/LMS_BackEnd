package com.wellsfargo.lms.repository;

import com.wellsfargo.lms.model.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCardRepository extends JpaRepository<EmployeeCard,Long> {
}
