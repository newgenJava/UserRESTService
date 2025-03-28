package com.ayuup.springboot.users.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 

@Repository
public interface UserJPARepository extends JpaRepository<User,Integer>{
	
	 Optional<User> findByName(String name);

}
