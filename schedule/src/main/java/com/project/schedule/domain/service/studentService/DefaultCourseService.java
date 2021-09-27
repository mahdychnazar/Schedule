package com.project.schedule.domain.service.studentService;

import com.project.schedule.domain.model.Course;

import java.util.List;

public interface DefaultCourseService {

    List<Course> getAllCourses();

    Course findById(long id);

    Course findByTitle(String title);

    void addCourse(Course course);
}
