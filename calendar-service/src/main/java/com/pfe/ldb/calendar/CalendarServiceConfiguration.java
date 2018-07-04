package com.pfe.ldb.calendar;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pfe.ldb.calendar.iservice.ICalendarService;
import com.pfe.ldb.calendar.service.CalendarService;

@Configuration
@ComponentScan(basePackages = { "com.pfe.ldb.event"})
@EntityScan("com.pfe.ldb.entity")
@EnableJpaRepositories("com.pfe.ldb.event.repository")
@Profile({"dev","prod"})
public class CalendarServiceConfiguration {

    @Bean
    @Primary
    public ICalendarService calendarService() {
    	return new CalendarService();
    }
    
}
