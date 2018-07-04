package com.pfe.ldb.event.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pfe.ldb.event.iservice.IEventService;
import com.pfe.ldb.event.service.EventService;


@Configuration
@ComponentScan(basePackages = { "com.pfe.ldb.event"})
@EntityScan("com.pfe.ldb.entity")
@EnableJpaRepositories("com.pfe.ldb.event.repository")
@Profile({"dev","prod"})
public class EventServiceConfiguration {

    @Bean
    @Primary
    public IEventService eventService() {
    	return new EventService();
    }
    
}
