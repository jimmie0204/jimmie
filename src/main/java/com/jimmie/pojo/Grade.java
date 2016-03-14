package com.jimmie.pojo;

import java.util.ArrayList;
import java.util.List;

public class Grade {

	private String name;
	
	private List<User> user = new ArrayList<User>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
}
