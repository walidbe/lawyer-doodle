package com.pfe.ldb.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ldb.core.protogest.user.User;
import com.pfe.ldb.member.controller.path.PathURI;
import com.pfe.ldb.member.iservice.ISecurityService;
import com.pfe.ldb.member.iservice.IUserService;

@RestController
public class MemberController {

	@Autowired
	private IUserService userService;

	@Autowired
	private ISecurityService securityService;
	
	@RequestMapping(method = RequestMethod.POST, value = PathURI.USER_REGISTER)
    public String registration(@RequestBody(required = true) final User user) throws Exception {
        userService.save(user);
        return "Success";
    }
	
	@RequestMapping(method = RequestMethod.POST, value = PathURI.USER_LOGIN)
    public String login(@RequestBody(required = true) final User user) throws Exception {
        securityService.login(user.getUsername(), user.getPassword());
        return "Success";
    }

    
}
