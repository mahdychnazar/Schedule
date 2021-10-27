package com.project.schedule.api.controller;

import com.project.schedule.domain.model.StudentModel;
import com.project.schedule.domain.service.studentService.DefaultStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Collections;

@Controller
@ConditionalOnProjectEnabledAnnotation
public class MainController {

    DefaultStudentService defaultStudentService;

    @Autowired
    public void setDefaultStudentService(DefaultStudentService defaultStudentService) {
        this.defaultStudentService = defaultStudentService;
    }

    @GetMapping("/")
    public String getMainPage(){
        StudentModel student = new StudentModel(2L,"Nazar","nazar",19, LocalDateTime.parse("2002-07-02T12:02"), Collections.emptySet());
        defaultStudentService.addStudent(student);
        System.out.println(defaultStudentService.findByEmail("nazar"));
        return "main";
    }

    @GetMapping("/lol")
    public String getMainPage1(){
        System.out.println("sad face");
        return "main";
    }
}
