package com.project.schedule.domain.service.studentService;

import com.project.schedule.domain.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService implements DefaultCourseService{

    private Map<Long, Course> courseMap = new HashMap<>();

    @Override
    public List<Course> getAllCourses() {
        return new ArrayList<>(courseMap.values());
    }

    @Override
    public Course findById(long id) {
        return courseMap.get(id);
    }

    @Override
    public Course findByTitle(String title) {
        return courseMap.values().stream().filter(course -> course.getTitle().equals(title)).findAny().get();
    }

    @Override
    public void addCourse(Course course) {
        courseMap.put(course.getId(), course);
    }
}
