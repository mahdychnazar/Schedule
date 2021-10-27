package com.project.schedule.domain.model;

import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

public class StudentModel {

    @NotNull
    Long id;
    @NotBlank(message = "Name can't be blank.")
    String name;
    @Email(message = "Invalid email.")
    String email;
    @Min(0)
    int age;
    @NotBlank(message = "Birth date can't be blank.")
    LocalDateTime birthDate;
    Set<Long> courseModels;

    public StudentModel() {
    }

    public StudentModel(@NotNull Long id, @NotBlank(message = "Name can't be blank.") String name, @Email(message = "Invalid email.") String email, @Min(0) int age, @NotBlank(message = "Birth date can't be blank.") LocalDateTime birthDate, Set<Long> courseModels) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.birthDate = birthDate;
        this.courseModels = courseModels;
    }

    @NotNull
    public Long getId() {
        return id;
    }

    public void setId(@NotNull Long id) {
        this.id = id;
    }

    @NotBlank(message = "Name can't be blank.")
    public String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name can't be blank.") String name) {
        this.name = name;
    }

    @Min(0)
    public int getAge() {
        return age;
    }

    public void setAge(@Min(0) int age) {
        this.age = age;
    }

    @NotBlank(message = "Birth date can't be blank.")
    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NotBlank(message = "Birth date can't be blank.") LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    @Email(message = "Invalid email.")
    public String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Invalid email.") String email) {
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
