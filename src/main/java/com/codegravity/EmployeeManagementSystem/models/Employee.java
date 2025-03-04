
package com.codegravity.EmployeeManagementSystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Data // Generates Getters, Setters, toString, hashCode, equals
@NoArgsConstructor // Generates No-Arg Constructor
@AllArgsConstructor // Generates All-Args Constructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotBlank(message = "First name cannot be empty")
    @Size(max = 50, message = "First name should be at most 50 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Size(max = 50, message = "Last name should be at most 50 characters")
    private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone;

    @Embedded
    private VisaDetails visaDetails;

    @Embedded
    private EducationDetails educationDetails;
}
