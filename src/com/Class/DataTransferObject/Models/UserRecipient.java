package com.Class.DataTransferObject.Models;

import java.sql.Timestamp;
import java.util.List;

import com.Class.DataTransferObject.Enums.UserType;

public class UserRecipient extends User {
	
	private List<Document> receivedDocuments;
	
	public UserRecipient(String name, String email) {
		super(name, email, UserType.RECIPIENT);
	}
	
	public UserRecipient(String name, String email, UserType type) {
		super(name, email, type);
	}
	
	public UserRecipient(long id, String name, String email,  Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, name, email, UserType.RECIPIENT, createdAt, updatedAt, deletedAt);
	}
	
	public UserRecipient(long id, String name, String email, UserType type,  Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, name, email, type, createdAt, updatedAt, deletedAt);
	}

	public List<Document> getReceivedDocuments() {
		return receivedDocuments;
	}
	
	public void setReceivedDocuments(List<Document> receivedDocuments) {
		this.receivedDocuments = receivedDocuments;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserRecipient [receivedDocuments=");
		builder.append(receivedDocuments);
		builder.append("]");
		return builder.toString();
	}

}
