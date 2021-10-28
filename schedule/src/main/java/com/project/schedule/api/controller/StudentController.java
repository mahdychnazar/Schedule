package com.project.schedule.api.controller;

import com.project.schedule.domain.model.StudentModel;
import com.project.schedule.domain.service.studentService.DefaultStudentService;
import com.project.schedule.exceptions.CourseNotFoundException;
import com.project.schedule.exceptions.UserNotFoundException;
import com.project.schedule.persistence.repository.entity.Student;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    DefaultStudentService defaultStudentService;

    public StudentController(DefaultStudentService defaultCourseService) {
        this.defaultStudentService = defaultCourseService;
    }

    @GetMapping("/students-info")
    public Object getStudents(){
        List<StudentModel> allStudents = defaultStudentService.getAllStudents();
        System.out.println(allStudents);
        return allStudents;
    }

    @PostMapping("/createStudent")
    public StudentModel createStudent(@Valid StudentModel studentModel){
        defaultStudentService.addStudent(studentModel);
        return defaultStudentService.findById(studentModel.getId());
    }

    @GetMapping("/students/{id}")
    public StudentModel getStudent(@PathVariable String id){
        return defaultStudentService.findById(Long.parseLong(id));
    }


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

    @PatchMapping("/update/student/{id}")
    public StudentModel updateStudentName (@PathVariable(name = "id") String id){
        StudentModel newStudent = defaultStudentService.findById(Long.parseLong(id));
        newStudent.setName("New name");
        defaultStudentService.addStudent(newStudent);
        return newStudent;
    }

    @DeleteMapping("/delete/student/{id}")
    public void deleteStudent (@PathVariable(name = "id") String id) {
        defaultStudentService.deleteStudentById(Long.parseLong(id));
    }

    @ExceptionHandler({UserNotFoundException.class})
    public void handleException(){
        System.out.println("User is not found.");
    }
}
