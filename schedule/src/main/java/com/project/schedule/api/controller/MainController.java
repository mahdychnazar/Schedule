package com.project.schedule.api.controller;

import com.project.schedule.domain.model.Student;
import com.project.schedule.domain.service.studentService.DefaultStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class MainController {

    DefaultStudentService defaultStudentService;

    @Autowired
    public void setDefaultStudentService(DefaultStudentService defaultStudentService) {
        this.defaultStudentService = defaultStudentService;
    }

    @GetMapping("/")
    public String getMainPage(){
        Student student = new Student(1L,"Nazar","nazar",19, LocalDateTime.parse("2002-07-02T12:02"));
        defaultStudentService.addStudent(student);
        System.out.println(defaultStudentService.findByEmail("nazar"));
        return "main";
    }
}
