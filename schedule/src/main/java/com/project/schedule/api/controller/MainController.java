package com.project.schedule.api.controller;

import com.project.schedule.domain.model.Student;
import com.project.schedule.domain.service.studentService.DefaultStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class MainController {

    @Autowired
    DefaultStudentService defaultStudentService;

    @GetMapping("/")
    public String getMainPage(){
        Student student = new Student(1L,"Alex","sasha",12, LocalDateTime.parse("2002-02-12T12:02"));
        defaultStudentService.addStudent(student);
        System.out.println(defaultStudentService.findByEmail("sasha"));
        return "main";
    }
}
