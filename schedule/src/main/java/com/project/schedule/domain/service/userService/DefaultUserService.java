package com.project.schedule.domain.service.userService;

import com.project.schedule.persistence.repository.entity.User;

import java.util.List;

public interface DefaultUserService {

    List<User> getAllStudents();

    User findById(long id);

    User findByUsername(String username);

    void addUser(User student);

    void deleteUserById(long id);
}
