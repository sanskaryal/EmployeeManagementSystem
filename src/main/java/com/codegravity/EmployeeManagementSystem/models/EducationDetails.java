package com.codegravity.EmployeeManagementSystem.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationId; // Primary Key

    private String universityName;
    private String degreeType;
    private LocalDate graduationDate;
    private String transcript;

    @OneToOne(mappedBy = "educationDetails")
    private Employee employee;
}
