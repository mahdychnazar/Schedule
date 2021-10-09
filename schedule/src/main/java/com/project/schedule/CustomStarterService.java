package com.project.schedule;

import com.project.customstarter.service.StarterService;

public class CustomStarterService implements StarterService {
    @Override
    public void starterFunc() {
        System.out.println("Hello custom Sasha!");
    }
}
