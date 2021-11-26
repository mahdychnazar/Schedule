package com.project.schedule.api.controller;

import com.project.schedule.domain.model.StudentModel;
import com.project.schedule.domain.service.studentService.DefaultStudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
@ConditionalOnProjectEnabledAnnotation
public class MainController {

    DefaultStudentService defaultStudentService;
    private static final Logger logger = LogManager.getLogger(MainController.class);

    @Autowired
    public void setDefaultStudentService(DefaultStudentService defaultStudentService) {
        this.defaultStudentService = defaultStudentService;
    }

    @GetMapping("/")
    public String getMainPage(){
        StudentModel student = new StudentModel(2L,"Nazar","nazar",19, "2002-07-02T12:02", Collections.emptySet());
        defaultStudentService.addStudent(student);
        logger.info(defaultStudentService.findByEmail("nazar"));
        return "main";
    }

    @GetMapping("/home")
    public String home(@RequestParam(required = false) String login, Model model) {
        logger.info("login is: " + login);
        model.addAttribute("login", login);
        return "homePage";
    }

    @GetMapping("/lol")
    public String getMainPage1(){
        logger.info("sad face");
        return "main";
    }
}
