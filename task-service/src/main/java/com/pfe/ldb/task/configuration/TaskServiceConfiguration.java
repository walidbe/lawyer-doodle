package com.pfe.ldb.task.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pfe.ldb.task.iservice.ITaskService;
import com.pfe.ldb.task.service.TaskService;

@Configuration
@ComponentScan(basePackages = { "com.pfe.ldb.task"})
@EntityScan("com.pfe.ldb.entity")
@EnableJpaRepositories("com.pfe.ldb.task.repository")
@Profile({"dev","prod"})
public class TaskServiceConfiguration {

    @Bean
    @Primary
    public ITaskService taskService() {
    	return new TaskService();
    }
    
}
