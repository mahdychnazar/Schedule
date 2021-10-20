package com.project.schedule.domain.model;

import java.util.Set;


public class CourseModel {

    Long id;
    String title;
    String description;
    String lector;
    Set<Long> studentModelSet;

    public CourseModel() {
    }

    public CourseModel(Long id, String title, String description, String lector, Set<Long> studentModels) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.lector = lector;
        this.studentModelSet = studentModels;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<Long> getStudentModelSet() {
        return studentModelSet;
    }

    public void setStudentModelSet(Set<Long> studentModelSet) {
        this.studentModelSet = studentModelSet;
    }

    @Override
    public String toString() {
        return "CourseModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", lector='" + lector + '\'' +
                ", studentModelSet=" + studentModelSet +
                '}';
    }
}
