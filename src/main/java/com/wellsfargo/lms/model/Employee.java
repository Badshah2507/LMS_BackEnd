package com.wellsfargo.lms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    String employeeId;
    String employeeName;
    String designation;
    String department;
    String gender;
    @JsonFormat(pattern = "dd/mm/yyyy")
    Date dateOfBirth;
    @JsonFormat(pattern = "dd/mm/yyyy")
    Date dateOfJoining;
}
