package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "UserData")
public class UserDataEntity {
	@Id
	@GeneratedValue
	private Long id;
	private String name;

	public UserDataEntity() {
		super();
	}

	public UserDataEntity(Long id, String name) {
		super();
		this.id = id;
		this.name = name;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
