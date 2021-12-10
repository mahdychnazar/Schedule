package com.project.schedule.persistence.repository.CourseRepo;


import com.project.schedule.domain.model.CourseModel;
import com.project.schedule.persistence.repository.entity.Course;

import java.util.List;

public interface DefaultCourseRepo {

    List<Course> getAllCourses();

    Course findById(long id);

    Course findByTitle(String title);

    void addCourse(CourseModel course);

    List<Course> findByAuthor(String name);
}
