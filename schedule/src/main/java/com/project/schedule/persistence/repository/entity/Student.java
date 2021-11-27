package com.project.schedule.persistence.repository.entity;

import lombok.Builder;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id
    Long id;

    @NonNull
    @Column(name = "name")
    String name;

    @NonNull
    @Column(name = "email")
    String email;

    @Column(name = "age")
    int age;

    @NonNull
    @Column(name = "birthdate")
    LocalDateTime birthDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "students_courses", joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "id")
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id", referencedColumnName = "id")
            })
    Set<Course> courses = new HashSet<>();

    public Student(){

    }

    @Builder
    public Student(Long id, @NonNull String name, @NonNull String email, int age, @NonNull LocalDateTime birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @NonNull
    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NonNull LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                '}';
    }
}
