package com.project.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "freelancer")
public class Freelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer freelancerId;

    private String description;
    private String education;
    private String cvLink;
    private String location;

    public Integer getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(Integer freelancerId) {
        this.freelancerId = freelancerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCvLink() {
        return cvLink;
    }

    public void setCvLink(String cvLink) {
        this.cvLink = cvLink;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
