package com.ayuup.springboot.users.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserDaoService daoService;

	public UserResource(UserDaoService daoService) {
		super();
		this.daoService = daoService;
	}

	@GetMapping(path = "/users")
	public List<User> findAllUsers() {
		return daoService.findAllUsers();
	}

	@GetMapping(path = "/users/{id}")
	public User findUserById(@PathVariable int id) {
		return daoService.findUserById(id);
	}

	@PostMapping(path = "/users")
	public void addUser(@Valid @RequestBody User user) {
		
		daoService.addUser(user);
		return;
		
	}
}
