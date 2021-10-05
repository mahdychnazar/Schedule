package com.project.schedule.persistence.repository.CourseRepo;


import com.project.schedule.domain.model.CourseModel;

import java.util.Set;

public interface DefaultCourseRepo {

    Set<CourseModel> getAllCourses();

    CourseModel findById(long id);

    CourseModel findByTitle(String title);

    void addCourse(CourseModel course);
}
