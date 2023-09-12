package com.wellsfargo.lms.repository;

import com.wellsfargo.lms.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
