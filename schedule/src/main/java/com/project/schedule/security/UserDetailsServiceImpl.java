package com.project.schedule.security;

import com.project.schedule.persistence.repository.UserRepo.UserRepo;
import com.project.schedule.persistence.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user != null)
            return new CustomUserDetails(user);
        else
            throw new UsernameNotFoundException("User " + username + " not found!");
    }
}
