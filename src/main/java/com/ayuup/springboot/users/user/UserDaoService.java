package com.ayuup.springboot.users.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static int userCount = 3;

	private static List<User> userList = new ArrayList<>();
	static {
		userList.add(new User(1, "Name1"));
		userList.add(new User(2, "Name2"));
		userList.add(new User(33, "3"));
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userList;
	}

	public Optional<User> findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		Optional<User> user = userList.stream().filter(predicate).findFirst();

		return user;
	}

	public User save(User user) {
		if (user.getId() == null || user.getId() == 0) {
			user.setId(++userCount);
		}

		Predicate<? super User> predicate = userPred -> userPred.getId().equals(user.getId());
		Optional<User> userToBeAdded = userList.stream().filter(predicate).findFirst();

		if (userToBeAdded.isPresent()) {
			throw new UserAlreadyExistException(" User found for id : " + user.getId(), user.getId());
		}

		userList.add(user);
		return user;
	}
}
