package com.project.schedule.domain.service.userService;

import com.project.schedule.persistence.repository.UserRepo.DefaultUserRepo;
import com.project.schedule.persistence.repository.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements DefaultUserService {

    DefaultUserRepo userRepo;

    public UserService(DefaultUserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public List<User> getAllStudents() {
        return userRepo.getAllUsers();
    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void addUser(User user) {
        userRepo.addUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepo.deleteUserById(id);
    }
}
