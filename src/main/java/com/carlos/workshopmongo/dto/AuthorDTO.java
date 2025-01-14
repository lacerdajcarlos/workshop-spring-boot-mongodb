package com.carlos.workshopmongo.dto;

import java.io.Serializable;

import com.carlos.workshopmongo.domain.User;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String user;

	public AuthorDTO() {

	}

	public AuthorDTO(User obj) {
		id = obj.getId();
		user = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
