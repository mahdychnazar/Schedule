package com.project.schedule.domain.model;

public class Course {

    Long id;
    String title;
    String description;
    String lector;

    public Course(Long id, String title, String description, String lector) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.lector = lector;
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
