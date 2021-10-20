package com.project.schedule.persistence.repository.CourseRepo;

import com.project.schedule.domain.model.CourseModel;
import com.project.schedule.persistence.mapper.MainMapper;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
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
    public Set<CourseModel> getAllCourses() {
        return MainMapper.coursesToCoursesModel(new HashSet<>(courseRepo.findAll()));
    }

    @Override
    public CourseModel findById(long id) {
        return MainMapper.courseToCourseModel(courseRepo.findById(id).get());
    }

    @Override
    public CourseModel findByTitle(String title) {
        return MainMapper.courseToCourseModel(courseRepo.findByTitle(title).get());
    }

    @Override
    public void addCourse(CourseModel course) {
        courseRepo.save(MainMapper.courseModelToCourse(course));
    }

    @Override
    public Set<CourseModel> findByAuthor(String name) {
        return MainMapper.coursesToCoursesModel(courseRepo.findByLector(name));
    }
}
