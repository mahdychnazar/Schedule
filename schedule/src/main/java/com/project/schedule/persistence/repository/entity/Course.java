package com.project.schedule.persistence.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    List<Student> studentSet = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "courses_timeslots", joinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id")
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "timeslot_id", referencedColumnName = "id")
            })
    Set<TimeForCourseEntity> timeForCourses = new HashSet<>();

    public Course(){

    }

    public Course(long id, String title, String description, String lector, List<Student> studentSet, Set<WeekDays> days) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.lector = lector;
        this.studentSet = studentSet;
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

    public List<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(List<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public Set<TimeForCourseEntity> getTimeForCourses() {
        return timeForCourses;
    }

    public void setTimeForCourses(Set<TimeForCourseEntity> timeForCourses) {
        this.timeForCourses = timeForCourses;
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
