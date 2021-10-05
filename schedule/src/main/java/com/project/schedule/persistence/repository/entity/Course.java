package com.project.schedule.persistence.repository.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "lector")
    String lector;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    Set<Student> studentSet = new HashSet<>();

    public Course(){

    }

    public Course(long id, String title, String description, String lector) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.lector = lector;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLector() {
        return lector;
    }

    public void setLector(String lector) {
        this.lector = lector;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", lector='" + lector + '\'' +
                '}';
    }
}
