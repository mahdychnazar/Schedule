package com.project.schedule.api.controller;

import com.project.schedule.domain.model.CourseModel;
import com.project.schedule.domain.model.StudentModel;
import com.project.schedule.domain.service.studentService.DefaultCourseService;
import com.project.schedule.exceptions.CourseNotFoundException;
import com.project.schedule.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
public class CourseController {

    DefaultCourseService defaultCourseService;

    public CourseController(DefaultCourseService defaultCourseService) {
        this.defaultCourseService = defaultCourseService;
    }

    @GetMapping("/courses-info")
    public Object getCourses(){
        Set<CourseModel> allCourses = defaultCourseService.getAllCourses();
        System.out.println(allCourses);
        return allCourses;
    }

    @PostMapping("/createCourse")
    public CourseModel createCourse(@Valid CourseModel courseModel){
        defaultCourseService.addCourse(courseModel);
        return defaultCourseService.findById(courseModel.getId());
    }

    @PutMapping("/update/course/{id}")
    public CourseModel updateCourse (@PathVariable(name = "id") String id) throws CourseNotFoundException {
        try {
            CourseModel newCourse = defaultCourseService.findById(Long.parseLong(id));
            newCourse.setTitle("New title");
            defaultCourseService.addCourse(newCourse);
            return newCourse;
        } catch (Exception e){
            throw new CourseNotFoundException("Course is not found.");
        }
    }

    @ExceptionHandler({CourseNotFoundException.class})
    public void handleException(){
        System.out.println("Course is not found.");
    }

}
