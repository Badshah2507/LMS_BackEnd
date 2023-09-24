package com.wellsfargo.lms.model;

import jakarta.persistence.*;
import lombok.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @SequenceGenerator(name = "UUID", initialValue = 101, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "UUID")
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String password;
    private String role;
    private String employeeId;

    public void setPassword(String password) {
        Base64.Encoder encoder = Base64.getEncoder();
        this.password = encoder.encodeToString(password.getBytes(StandardCharsets.UTF_8));
    }
}
