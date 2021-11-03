package com.project.schedule.domain.service.studentService;

import com.project.schedule.ScheduleApplication;
import com.project.schedule.domain.model.CourseModel;
import com.project.schedule.persistence.mapper.MainMapper;
import com.project.schedule.persistence.repository.CourseRepo.DefaultCourseRepo;
import org.apache.logging.log4j.*;
import org.jboss.jandex.Main;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;

@Service
public class CourseService implements DefaultCourseService{

    private static final Logger logger = LogManager.getLogger(ScheduleApplication.class);
    private static final Marker COURSE_MARKER = MarkerManager.getMarker("checkCourse");

    DefaultCourseRepo courseRepo;

    public CourseService(DefaultCourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<CourseModel> getAllCourses() {
        return MainMapper.coursesToCoursesModel(courseRepo.getAllCourses());
    }

    @Override
    public CourseModel findById(long id) {
        return MainMapper.courseToCourseModel(courseRepo.findById(id));
    }

    @Override
    public CourseModel findByTitle(String title) {
        return MainMapper.courseToCourseModel(courseRepo.findByTitle(title));
    }

    @Override
    public List<CourseModel> findByAuthor(String name) {
        return MainMapper.coursesToCoursesModel(courseRepo.findByAuthor(name));
    }

    @Override
    public void addCourse(CourseModel course) {
        ThreadContext.put("course.id", course.getId().toString());
        ThreadContext.put("course.name", course.getDescription());
        courseRepo.addCourse(course);
        logger.info(COURSE_MARKER, "Course having id {} and name {} is added", course.getId(), course.getDescription() );
        ThreadContext.clearAll();
    }
}
