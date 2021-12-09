package com.project.schedule.api.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableCaching
public class CachingConfig {
    @Bean
    public CacheManager cacheManager() {
        CustomCacheManager cacheManager = new CustomCacheManager();
        cacheManager.setCaches(
                Arrays.asList(
                        new ConcurrentMapCache("student"),
                        new ConcurrentMapCache("studentEmail"),
                        new ConcurrentMapCache("course"),
                        new ConcurrentMapCache("courseTitle"),
                        new ConcurrentMapCache("students"),
                        new ConcurrentMapCache("courses")));
        return cacheManager;
    }
}
