package com.pfe.ldb.calendar.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.pfe.ldb.calendar.iservice.ICalendarService;
import com.pfe.ldb.calendar.service.CalendarService;


@Configuration
@ComponentScan(basePackages = { "com.pfe.ldb.calendar"})
@EntityScan("com.pfe.ldb.entity")
@Profile({"dev","prod"})
public class CalendarServiceConfiguration {

    @Bean
    @Primary
    public ICalendarService taskService() {
    	return new CalendarService();
    }
    
}
