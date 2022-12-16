package com.Class.DataTransferObject.Models;

import java.sql.Timestamp;

import com.Class.DataTransferObject.Enums.UserType;

public class User {
	
	private long id;
	
	private String name;
	
	private String email;
	
	private UserType type;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;
	
	private Timestamp deletedAt;
	
	public User() {
		
	}
	
	public User(long id) {
		setId(id);
	}
	
	public User(UserType type) {
		setType(type);
	}
	
	public User(String name, String email, UserType type) {
		setName(name);
		setEmail(email);
		setType(type);
	}

	public User(long id, String name, String email, UserType type, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		setId(id);
		setName(name);
		setEmail(email);
		setType(type);
		setCreatedAt(createdAt);
		setUpdatedAt(updatedAt);
		setDeletedAt(deletedAt);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", type=");
		builder.append(type);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", deletedAt=");
		builder.append(deletedAt);
		builder.append("]");
		return builder.toString();
	}

}
