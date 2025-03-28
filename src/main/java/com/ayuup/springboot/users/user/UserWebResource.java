package com.ayuup.springboot.users.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserWebResource {
	
	
	@Autowired
	private UserDaoService daoService;

	@GetMapping(path = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(path = "/")
	public String homePage() {
		return "login";
	}
	
	@GetMapping(path = "/signup")
	public String signupPage() {
		return "signup";
	}
	
	@GetMapping(path = "/admin")
	public String sadminPage() {
		return "admin";
	}


}
