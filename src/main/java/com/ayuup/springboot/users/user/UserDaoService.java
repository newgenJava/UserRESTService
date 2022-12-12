package com.ayuup.springboot.users.user;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static int userCount = 3;
	
	private static List<User> userList = new ArrayList<>();
	static {
		userList.add( new User( 1, "Name1" ));
		userList.add( new User( 2, "Name2" ));
		userList.add( new User( 33, "3" ));
	}
	

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userList;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		User user = userList.stream().filter(predicate).findFirst().get() ;
		
		return user ;
	}
	
	public User save(User user) {
		if( user.getId() == null ) {
			user.setId(++userCount);
		}
		userList.add(user);
		return user;
	}
}
