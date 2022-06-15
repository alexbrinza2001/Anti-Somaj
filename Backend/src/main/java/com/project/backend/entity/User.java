package com.project.backend.entity;

import com.project.backend.entity.Employer;
import com.project.backend.entity.Freelancer;
import com.project.backend.entity.Role;
import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    private String email;
    private String firstName;
    private String lastName;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "freelancer_id")
    private Freelancer freelancer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();
    private Integer employerId;
    private Integer freelancerId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Freelancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Integer getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Integer employerId) {
        this.employerId = employerId;
    }

    public Integer getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(Integer freelancerId) {
        this.freelancerId = freelancerId;
    }


    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
