package com.project.schedule.domain.service.studentService;

import com.project.schedule.domain.model.CourseModel;
import com.project.schedule.persistence.repository.CourseRepo.DefaultCourseRepo;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CourseService implements DefaultCourseService{

    DefaultCourseRepo courseRepo;


    public CourseService(DefaultCourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public Set<CourseModel> getAllCourses() {
        return courseRepo.getAllCourses();
    }

    @Override
    public CourseModel findById(long id) {
        return courseRepo.findById(id);
    }

    @Override
    public CourseModel findByTitle(String title) {
        return courseRepo.findByTitle(title);
    }

    @Override
    public void addCourse(CourseModel course) {
        courseRepo.addCourse(course);
    }
}
