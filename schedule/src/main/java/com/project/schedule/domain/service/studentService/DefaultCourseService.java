package com.project.schedule.domain.service.studentService;

import com.project.schedule.domain.model.CourseModel;

import java.util.Set;

public interface DefaultCourseService {

    Set<CourseModel> getAllCourses();

    CourseModel findById(long id);

    CourseModel findByTitle(String title);

    Set<CourseModel> findByAuthor(String name);

    void addCourse(CourseModel course);
}
