package com.pfe.ldb.member.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pfe.ldb.member.iservice.IUserService;
import com.pfe.ldb.member.service.UserService;


@Configuration
@ComponentScan(basePackages = { "com.pfe.ldb.member"})
@EntityScan("com.pfe.ldb.entity")
@EnableJpaRepositories("com.pfe.ldb.member.repository")
@Profile({"dev","prod"})
public class MemberServiceConfiguration {

    
    @Bean
    @Primary
    public IUserService userService() {
    	return new UserService();
    }
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
