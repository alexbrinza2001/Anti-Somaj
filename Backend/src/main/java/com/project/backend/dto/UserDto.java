package com.project.backend.dto;

import java.util.Collection;

public class UserDto {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Collection<RoleDto> roles;
    private FreelancerDto freelancer;
    private EmployerDto employer;

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

    public FreelancerDto getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(FreelancerDto freelancer) {
        this.freelancer = freelancer;
    }

    public EmployerDto getEmployer() {
        return employer;
    }

    public void setEmployer(EmployerDto employer) {
        this.employer = employer;
    }

    public void addRole(RoleDto role){
        this.roles.add(role);
    }

    public Collection<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleDto> roles) {
        this.roles = roles;
    }
}
