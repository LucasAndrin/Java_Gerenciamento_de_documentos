package com.Class.DataTransferObject.Models;

import java.sql.Timestamp;

import com.Class.DataTransferObject.Enums.UserType;

public class UserAdmin extends UserResponsible {

	public UserAdmin() {
		super(UserType.ADMIN);
	}
	
	public UserAdmin(long id) {
		super(id);
	}
	
	public UserAdmin(String name, String email) {
		super(name, email, UserType.ADMIN);
	}

	public UserAdmin(long id, String name, String email, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, name, email, UserType.ADMIN, createdAt, updatedAt, deletedAt);
	}

	public UserAdmin(long id, String name, String email, UserType type, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, name, email, type, createdAt, updatedAt, deletedAt);
	}
	
}
