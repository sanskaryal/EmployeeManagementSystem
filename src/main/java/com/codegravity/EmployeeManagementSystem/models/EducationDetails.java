package com.codegravity.EmployeeManagementSystem.models;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDate;

@Embeddable
@Data // Lombok: Generates Getters, Setters, toString, hashCode, equals
@NoArgsConstructor // Generates No-Arg Constructor
@AllArgsConstructor // Generates All-Args Constructor
public class EducationDetails {
    private String universityName;
    private String degreeType;
    private LocalDate graduationDate; // Changed from String to LocalDate
    private String transcript;
}
