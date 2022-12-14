package com.ayuup.springboot.users.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private int id;
	
	private String description;

	@ManyToOne
	@JsonIgnore
	private User user;

	public Post() {
		super();
	}

	public Post(int id, User user, String description) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", user=" + user + ", description=" + description + "]";
	}

}
