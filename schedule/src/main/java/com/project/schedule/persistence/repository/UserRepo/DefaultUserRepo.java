package com.project.schedule.persistence.repository.UserRepo;

import com.project.schedule.persistence.repository.entity.User;

import java.util.List;

public interface DefaultUserRepo {

    List<User> getAllUsers();

    User findById(long id);

    User findByUsername(String username);

    void addUser(User student);

    void deleteUserById(long id);
}
