package com.codegravity.EmployeeManagementSystem.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "employee_id", length = 50, nullable = false)
    private String employeeId;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "dob", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "university_name", length = 200)
    private String universityName;

    @Column(name = "degree_type", length = 100)
    private String degreeType;

    @Column(name = "graduation_date")
    @Temporal(TemporalType.DATE)
    private Date graduationDate;

    @Column(name = "transcript", columnDefinition = "TEXT")
    private String transcript;

    @Column(name = "visa_status", length = 50)
    private String visaStatus;

    @Column(name = "visa_start_date")
    @Temporal(TemporalType.DATE)
    private Date visaStartDate;

    @Column(name = "visa_end_date")
    @Temporal(TemporalType.DATE)
    private Date visaEndDate;

    @Column(name = "visa_document", columnDefinition = "TEXT")
    private String visaDocument;

    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    public String getVisaStatus() {
        return visaStatus;
    }

    public void setVisaStatus(String visaStatus) {
        this.visaStatus = visaStatus;
    }

    public Date getVisaStartDate() {
        return visaStartDate;
    }

    public void setVisaStartDate(Date visaStartDate) {
        this.visaStartDate = visaStartDate;
    }

    public Date getVisaEndDate() {
        return visaEndDate;
    }

    public void setVisaEndDate(Date visaEndDate) {
        this.visaEndDate = visaEndDate;
    }

    public String getVisaDocument() {
        return visaDocument;
    }

    public void setVisaDocument(String visaDocument) {
        this.visaDocument = visaDocument;
    }
}
