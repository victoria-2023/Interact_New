package com.victoria.interact.model;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;
    @Column(name = "course_name",nullable = false)
    private String subject;
    @Column(name = "lecturer",nullable = false)
    private String lecturer;
    @Column(name = "description", nullable = false,unique = true)
    private String description;

    // Constructors
    public Course() {
    }

    public Course(String subject, String code, String description) {
        this.subject = subject;
        this.lecturer = lecturer;
        this.description = description;
    }

    public String getCode() {
        return lecturer;
    }

    public void setCode(String code) {
        this.lecturer = lecturer;
    }

}
