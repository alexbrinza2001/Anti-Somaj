package com.project.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "bugreport")
public class BugReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String bug;

    public String getBug() {
        return bug;
    }

    public void setBug(String bug) {
        this.bug = bug;
    }
}
