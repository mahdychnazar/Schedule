package com.project.schedule.domain.service.studentService;

import com.project.schedule.domain.model.CourseModel;

import java.util.List;
import java.util.Set;

public interface DefaultCourseService {

    Set<CourseModel> getAllCourses();

    CourseModel findById(long id);

    CourseModel findByTitle(String title);

    CourseModel findByAuthor(String name);

    void addCourse(CourseModel course);
}
