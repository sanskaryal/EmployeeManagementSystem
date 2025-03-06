package com.codegravity.EmployeeManagementSystem.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisaDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visaId; // Primary Key

    private String visaStatus;
    private LocalDate startDate;
    private LocalDate endDate;
    private String document;

    @OneToOne(mappedBy = "visaDetails")
    private Employee employee;
}
