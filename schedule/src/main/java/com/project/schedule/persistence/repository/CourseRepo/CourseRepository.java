package com.project.schedule.persistence.repository.CourseRepo;

import com.project.schedule.domain.model.CourseModel;
import com.project.schedule.persistence.mapper.MainMapper;
import com.project.schedule.persistence.repository.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Repository
public class CourseRepository implements DefaultCourseRepo{

    CourseRepo courseRepo;

    public CourseRepository(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course findById(long id) {
        return courseRepo.findById(id).get();
    }

    @Override
    public Course findByTitle(String title) {
        return courseRepo.findByTitle(title).get();
    }

    @Override
    public void addCourse(CourseModel course) {
        courseRepo.save(MainMapper.courseModelToCourse(course));
    }

    @Override
    public List<Course> findByAuthor(String name) {
        return courseRepo.findByLector(name);
    }
}
