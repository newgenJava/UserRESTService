package com.ayuup.springboot.users.user;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "'user_data'")
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 5, message = "CHar size more needed")
	private String name;

	@Past(message = "Date should be in past")
	private LocalDate birth_date;

	protected User() {

	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.birth_date = LocalDate.now();
	}

	public User(int id, String name, LocalDate dateTime) {
		super();
		this.id = id;
		this.name = name;
		this.birth_date = dateTime;
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
		return birth_date;
	}

	public void setDateTime(LocalDate dateTime) {
		this.birth_date = dateTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dateTime=" + birth_date + "]";
	}
}
