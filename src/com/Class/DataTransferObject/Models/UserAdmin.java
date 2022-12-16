package com.Class.DataTransferObject.Models;

import java.sql.Timestamp;
import java.util.List;

import com.Class.DataTransferObject.Enums.UserType;

public class UserAdmin extends UserResponsible {
	
	private List<Document> createdDocuments;

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
	
	public List<Document> getCreatedDocuments() {
		return createdDocuments;
	}

	public void setCreatedDocuments(List<Document> createdDocuments) {
		this.createdDocuments = createdDocuments;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserAdmin [createdDocuments=");
		builder.append(createdDocuments);
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
