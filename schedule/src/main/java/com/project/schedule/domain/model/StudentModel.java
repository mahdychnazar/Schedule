package com.project.schedule.domain.model;

import java.time.LocalDateTime;
import java.util.Set;

public class StudentModel {

    Long id;
    String name;
    String email;
    int age;
    LocalDateTime birthDate;
    Set<Long> courseModels;

    public StudentModel() {
    }

    public StudentModel(Long id, String name, String email, int age, LocalDateTime birthDate, Set<Long> courseModels) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.birthDate = birthDate;
        this.courseModels = courseModels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Long> getCourseModels() {
        return courseModels;
    }

    public void setCourseModels(Set<Long> courseModels) {
        this.courseModels = courseModels;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", courseModels=" + courseModels +
                '}';
    }
}
