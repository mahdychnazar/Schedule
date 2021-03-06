package com.project.schedule.api.controller;


import com.project.schedule.ScheduleApplication;
import com.project.schedule.persistence.repository.UserRepo.DefaultUserRepo;
import com.project.schedule.persistence.repository.entity.Role;
import com.project.schedule.persistence.repository.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {


    private final PasswordEncoder passwordEncoder;

    private static final Logger logger = LogManager.getLogger(ScheduleApplication.class);

    DefaultUserRepo userRepo;

    public RegistrationController(PasswordEncoder passwordEncoder, DefaultUserRepo userRepo) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.addUser(user);
        logger.info(userRepo.findByUsername(user.getUsername()));

        return "redirect:/login";
    }
}
