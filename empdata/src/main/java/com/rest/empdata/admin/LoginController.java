package com.rest.empdata.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ComponentScan(value="com.rest.empdata")
public class LoginController {
@Autowired
LoginService service;
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name,@RequestParam String password,ModelMap model) {
		if(!service.validateUser(name,password)) {
			model.put("errormessage","Invalid Credentials");
			return "login.jsp";
		}
			return "adminHome.jsp";
	}
}
