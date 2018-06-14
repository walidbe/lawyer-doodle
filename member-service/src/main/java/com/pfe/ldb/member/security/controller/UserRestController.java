package com.pfe.ldb.member.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ldb.member.controller.path.PathURI;
import com.pfe.ldb.member.security.JwtUser;


@RestController
public class UserRestController {



    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @RequestMapping(value = PathURI.USER_INFO, method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(Authentication auth) {

        String username = ((JwtUser)auth.getPrincipal()).getUsername();
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }

}
