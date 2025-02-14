package com.codegravity.EmployeeManagementSystem.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class VisaDetails {
    private String visaStatus;
    private String startDate;
    private String endDate;
    private String document;

    public VisaDetails(String visaStatus, String startDate, String endDate, String document) {
        this.visaStatus = visaStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.document = document;
    }

    public VisaDetails() {
    }

    public String getVisaStatus() {
        return visaStatus;
    }

    public void setVisaStatus(String visaStatus) {
        this.visaStatus = visaStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }


}
