package com.Class.DataTransferObject.Models;

import java.sql.Timestamp;
import java.util.List;

import com.Class.DataTransferObject.Enums.UserType;

public class UserResponsible extends UserRecipient {
	
	private List<Document> sentDocuments;
	
	public UserResponsible() {
		super(UserType.RESPONSIBLE);
	}
	
	public UserResponsible(long id) {
		super(id);
	}
	
	public UserResponsible(UserType type) {
		super(type);
	}
	
	public UserResponsible(String name, String email) {
		super(name, email, UserType.RESPONSIBLE);
	}

	public UserResponsible(String name, String email, UserType type) {
		super(name, email, type);
	}
	
	public UserResponsible(long id, String name, String email, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, name, email, UserType.RESPONSIBLE, createdAt, updatedAt, deletedAt);
	}
	
	public UserResponsible(long id, String name, String email, UserType type, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, name, email, type, createdAt, updatedAt, deletedAt);
	}

	public List<Document> getSentDocuments() {
		return sentDocuments;
	}

	public void setSentDocuments(List<Document> sentDocuments) {
		this.sentDocuments = sentDocuments;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserResponsible [sentDocuments=");
		builder.append(sentDocuments);
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

}
