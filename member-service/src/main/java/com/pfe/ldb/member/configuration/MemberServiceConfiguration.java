package com.pfe.ldb.member.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev","prod"})
public class MemberServiceConfiguration {

}
