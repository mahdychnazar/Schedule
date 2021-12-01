package com.project.schedule.api.controller;

import com.project.schedule.Aspects.LogParams;
import com.project.schedule.Aspects.LogTime;
import com.project.schedule.domain.model.CourseModel;
import com.project.schedule.domain.service.courseService.DefaultCourseService;
import com.project.schedule.exceptions.CourseNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
public class CourseController {

    DefaultCourseService defaultCourseService;
    private static final Logger logger = LogManager.getLogger(CourseController.class);

    public CourseController(DefaultCourseService defaultCourseService) {
        this.defaultCourseService = defaultCourseService;
    }

    @LogParams
    @LogTime
    @Operation(summary = "Get all courses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found courses",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) })})
    @GetMapping("/courses/info")
    public Object getCourses(Model model){
        List<CourseModel> allCourses = defaultCourseService.getAllCourses();
        logger.info(allCourses);
        model.addAttribute("courses", allCourses);
        return "courses";
    }
    @LogParams
    @LogTime
    @Operation(summary = "Get a course by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the course",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseModel.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Course not found",
                    content = @Content) })
    @GetMapping("/courses/{id}")
    public CourseModel getCourse(@PathVariable String id){
        return defaultCourseService.findById(Long.parseLong(id));
    }

    @LogParams
    @LogTime
    @Operation(summary = "Create course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created course",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseModel.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid course",
                    content = @Content)})
    @PostMapping("/create/course")
    public CourseModel createCourse(@Valid CourseModel courseModel){
        if (courseModel.getStudentModelSet() == null){
            courseModel.setStudentModelSet(Collections.emptyList());
        }
        defaultCourseService.addCourse(courseModel);
        return defaultCourseService.findById(courseModel.getId());
    }
    @LogParams
    @LogTime
    @Operation(summary = "Update a course by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the course",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseModel.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Course not found",
                    content = @Content) })
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
