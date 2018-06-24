package com.pfe.ldb.member.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ldb.core.protogest.user.User;
import com.pfe.ldb.member.controller.path.PathURI;
import com.pfe.ldb.member.iservice.ISecurityService;
import com.pfe.ldb.member.iservice.IUserService;
import com.pfe.ldb.member.security.JwtUser;


/*
 * Copyright [2018] [Walid Bezzaoui]
 * Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */


@RestController
public class MemberController {

	@Autowired
	private IUserService userService;

	@CrossOrigin(origins="http://localhost:3001")
	@RequestMapping(method = RequestMethod.POST, value = PathURI.USER_REGISTER)
    public String registration(@RequestBody(required = true) final User user) throws Exception {
        userService.save(user);
        return "Success";
    }

	

}
