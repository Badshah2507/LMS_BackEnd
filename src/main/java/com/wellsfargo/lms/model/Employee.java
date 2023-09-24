package com.wellsfargo.lms.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    String employeeId;
    String employeeName;
    String designation;
    String department;
    String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date dateOfBirth;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date dateOfJoining;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<EmployeeIssueDetails> employeeIssueDetails;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<EmployeeCard> employeeCards;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", designation='" + designation + '\'' +
                ", department='" + department + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }
}
