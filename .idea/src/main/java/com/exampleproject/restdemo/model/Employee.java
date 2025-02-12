package com.exampleproject.restdemo.mode;

public class Employee {

    private String employeeId;
    private String employeeFirstname;
    private String employeeLastname;
    private String employeeDob;
    private String email;
    private Integer phone;
    private EducationDetails educationDetails;
    private VisaDetails visaDetails;

    public Employee(String employeeId, String employeeFirstname, String employeeLastname, String employeeDob, String email, Integer phone, EducationDetails educationDetails, VisaDetails visaDetails) {
        this.employeeId = employeeId;
        this.employeeFirstname = employeeFirstname;
        this.employeeLastname = employeeLastname;
        this.employeeDob = employeeDob;
        this.email = email;
        this.phone = phone;
        this.educationDetails = educationDetails;
        this.visaDetails = visaDetails;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstname() {
        return employeeFirstname;
    }

    public void setEmployeeFirstname(String employeeFirstname) {
        this.employeeFirstname = employeeFirstname;
    }

    public String getEmployeeLastname() {
        return employeeLastname;
    }

    public void setEmployeeLastname(String employeeLastname) {
        this.employeeLastname = employeeLastname;
    }

    public String getEmployeeDob() {
        return employeeDob;
    }

    public void setEmployeeDob(String employeeDob) {
        this.employeeDob = employeeDob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public EducationDetails getEducationDetails() {
        return educationDetails;
    }

    public void setEducationDetails(EducationDetails educationDetails) {
        this.educationDetails = educationDetails;
    }

    public VisaDetails getVisaDetails() {
        return visaDetails;
    }

    public void setVisaDetails(VisaDetails visaDetails) {
        this.visaDetails = visaDetails;
    }

}
