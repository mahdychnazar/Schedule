package com.project.schedule.api.controller;

import com.project.schedule.Aspects.LogParams;
import com.project.schedule.Aspects.LogTime;
import com.project.schedule.domain.model.CourseModel;
import com.project.schedule.domain.model.StudentModel;
import com.project.schedule.domain.service.studentService.DefaultStudentService;
import com.project.schedule.exceptions.UserNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
@Tag(name = "Student controller", description = "default")
public class StudentController {

    DefaultStudentService defaultStudentService;

    public StudentController(DefaultStudentService defaultCourseService) {
        this.defaultStudentService = defaultCourseService;
    }

    @LogParams
    @LogTime
    @Operation(summary = "Get all students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned all students",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }) })
    @GetMapping("/students/info")
    public String getStudents(Model model){
        List<StudentModel> allStudents = defaultStudentService.getAllStudents();
        model.addAttribute("students", allStudents);
        return "students";
    }

    @LogParams
    @LogTime
    @Operation(summary = "Create student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the student",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentModel.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid students",
                    content = @Content)})
    @PostMapping("/create/student")
    public StudentModel createStudent(@Valid StudentModel studentModel){
        if(studentModel.getCourseModels() == null){
            studentModel.setCourseModels(Collections.emptySet());
        }
        defaultStudentService.addStudent(studentModel);
        return defaultStudentService.findById(studentModel.getId());
    }

    @LogParams
    @LogTime
    @Operation(summary = "Get a course by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get the course by id",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseModel.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content) })
    @GetMapping("/students/{id}")
    public StudentModel getStudent(@PathVariable String id){
        return defaultStudentService.findById(Long.parseLong(id));
    }

    @LogParams
    @LogTime
    @Operation(summary = "Update a student by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the student",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseModel.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content) })
    @PutMapping("/update/student/{id}")
    public StudentModel updateStudent (@PathVariable(name = "id") String id) throws UserNotFoundException {
        try {
            StudentModel newStudent = defaultStudentService.findById(Long.parseLong(id));
            newStudent.setEmail("updatedEmail");
            defaultStudentService.addStudent(newStudent);
            return newStudent;
        } catch (Exception e){
            throw new UserNotFoundException("Student is not found.");
        }
    }

    @LogParams
    @LogTime
    @Operation(summary = "Update a student by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the student",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseModel.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content) })
    @PatchMapping("/update/student/{id}")
    public StudentModel updateStudentName (@PathVariable(name = "id") String id){
        StudentModel newStudent = defaultStudentService.findById(Long.parseLong(id));
        newStudent.setName("New name");
        defaultStudentService.addStudent(newStudent);
        return newStudent;
    }

    @LogParams
    @LogTime
    @Operation(summary = "Delete a student by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the student",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseModel.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content) })
    @DeleteMapping("/delete/student/{id}")
    public void deleteStudent (@PathVariable(name = "id") String id) {
        defaultStudentService.deleteStudentById(Long.parseLong(id));
    }

    @ExceptionHandler({UserNotFoundException.class})
    public void handleException(){
        System.out.println("User is not found.");
    }
}

