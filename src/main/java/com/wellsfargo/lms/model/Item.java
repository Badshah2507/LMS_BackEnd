package com.wellsfargo.lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Item {
    @Id
    private String itemId;
    private String itemDescription;
    private String issueStatus;
    private String itemMake;
    private String itemCategory;
    private Integer itemValuation;

    @OneToMany(mappedBy = "item")
    private List<EmployeeIssueDetails> employeeIssueDetails;
}
