package com.ayuup.springboot.users.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {

	private Integer id;

	@Size(min = 5, message = "CHar size more needed")
	private String name;

	@Past(message = "Date should be in past")
	private LocalDate dateTime;

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.dateTime = LocalDate.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dateTime=" + dateTime + "]";
	}
}
