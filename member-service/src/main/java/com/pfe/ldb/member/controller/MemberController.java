package com.pfe.ldb.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ldb.core.protogest.user.User;
import com.pfe.ldb.member.controller.path.PathURI;
import com.pfe.ldb.member.iservice.IUserService;

@RestController
public class MemberController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = PathURI.USER_REGISTER, method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public String registration(@RequestBody(required = true) final User user) throws Exception {
        userService.save(user);
        return "Success";
    }
	
	
	@RequestMapping(value = PathURI.USER_REGISTER, method = RequestMethod.GET)
    public String login() throws Exception {
        return "login haha";
    }

    
}
