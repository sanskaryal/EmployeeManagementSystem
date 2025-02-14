package com.codegravity.EmployeeManagementSystem.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class EducationDetails {
    private String universityName;
    private String degreeType;
    private String graduationDate;
    private String transcript;

    public EducationDetails(String universityName, String degreeType, String graduationDate, String transcript) {
        this.universityName = universityName;
        this.degreeType = degreeType;
        this.graduationDate = graduationDate;
        this.transcript = transcript;
    }

    public EducationDetails() {
    }


    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public String getTranscript() {
        return transcript;
    }

}
