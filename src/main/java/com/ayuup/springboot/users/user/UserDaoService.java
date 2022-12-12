package com.ayuup.springboot.users.user;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> userList = new ArrayList<>();
	static {
		userList.add( new User( 1, "Name1" ));
		userList.add( new User( 2, "Name2" ));
		userList.add( new User( 33, "3" ));
	}
	

	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userList;
	}
	
	public User findUserById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		User user = userList.stream().filter(predicate).findFirst().get() ;
		
		return user ;
	}
	
	public void addUser(User user) {
		userList.add(user);
	}
	
	
}
