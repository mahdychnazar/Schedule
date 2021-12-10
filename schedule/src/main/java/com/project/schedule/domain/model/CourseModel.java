package com.project.schedule.domain.model;

import com.project.schedule.persistence.repository.entity.TimeForCourseEntity;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;


public class CourseModel {

    Long id;
    @NotBlank(message = "Title can't be blank.")
    String title;
    String description;
    @NotBlank(message = "Lector can't be blank.")
    String lector;
    List<Long> studentModelSet;

    Set<TimeForCourseEntity> timeForCourses;

    public CourseModel() {
    }

    public CourseModel(Long id, String title, String description, String lector, List<Long> studentModelSet, Set<TimeForCourseEntity> timeForCourses) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.lector = lector;
        this.studentModelSet = studentModelSet;
        this.timeForCourses = timeForCourses;
    }

    public CourseModel(Long id, @NotBlank(message = "Title can't be blank.") String title, String description, @NotBlank(message = "Lector can't be blank.") String lector, List<Long> studentModels) {
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

    @NotBlank(message = "Title can't be blank.")
    public String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title can't be blank.") String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotBlank(message = "Lector can't be blank.")
    public String getLector() {
        return lector;
    }

    public void setLector(@NotBlank(message = "Lector can't be blank.") String lector) {
        this.lector = lector;
    }

    public List<Long> getStudentModelSet() {
        return studentModelSet;
    }

    public void setStudentModelSet(List<Long> studentModelSet) {
        this.studentModelSet = studentModelSet;
    }

    public Set<TimeForCourseEntity> getTimeForCourses() {
        return timeForCourses;
    }

    public void setTimeForCourses(Set<TimeForCourseEntity> timeForCourses) {
        this.timeForCourses = timeForCourses;
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
