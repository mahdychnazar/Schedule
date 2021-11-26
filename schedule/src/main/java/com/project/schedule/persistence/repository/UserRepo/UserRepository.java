package com.project.schedule.persistence.repository.UserRepo;

import com.project.schedule.persistence.repository.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements DefaultUserRepo {

    UserRepo userRepo;

    public UserRepository(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepo.deleteById(id);
    }


}
