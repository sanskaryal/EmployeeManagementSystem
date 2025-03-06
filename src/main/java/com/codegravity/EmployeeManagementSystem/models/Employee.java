package com.codegravity.EmployeeManagementSystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone;

    // Establish One-to-One Relationship with EducationDetails
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "education_id", referencedColumnName = "educationId") // Foreign key
    private EducationDetails educationDetails;

    // Establish One-to-One Relationship with VisaDetails
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visa_id", referencedColumnName = "visaId") // Foreign key
    private VisaDetails visaDetails;
}
