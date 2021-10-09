package com.project.customstarter.config;

import com.project.customstarter.service.StarterService;
import com.project.customstarter.service.StarterServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(StarterService.class)
public class StarterServiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public StarterService starterService(){
        return new StarterServiceImpl();
    }

}
