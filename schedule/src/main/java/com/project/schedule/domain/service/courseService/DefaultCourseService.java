package com.project.schedule.domain.service.courseService;

import com.project.schedule.domain.model.CourseModel;

import java.util.List;

public interface DefaultCourseService {

    List<CourseModel> getAllCourses();

    CourseModel findById(long id);

    CourseModel findByTitle(String title);

    List<CourseModel> findByAuthor(String name);

    void addCourse(CourseModel course);
}
