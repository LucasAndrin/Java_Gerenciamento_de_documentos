package com.Class.DataTransferObject.Models;

import java.sql.Timestamp;
import java.util.List;

public class Document {
	
	private long id;
	
	private String file;
	
	private DocumentTemplate templateDocument;
	
	private List<UserRecipient> recipientUsers;
	
	private UserResponsible responsibleUser;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;
	
	private Timestamp deletedAt;
	
	public Document() {
		
	}
	
	public Document(DocumentTemplate templateDocument, List<UserRecipient> recipientUsers, UserResponsible responsibleUser) {
		setTemplateDocument(templateDocument);
		setRecipientUsers(recipientUsers);
		setResponsibleUser(responsibleUser);
	}

	public Document(long id, DocumentTemplate templateDocument, List<UserRecipient> recipientUsers, UserResponsible responsibleUser, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		setId(id);
		setTemplateDocument(templateDocument);
		setRecipientUsers(recipientUsers);
		setResponsibleUser(responsibleUser);
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
	
	public String getFile() {
		return file;
	}
	
	public void setFile(String file) {
		this.file = file;
	}

	public DocumentTemplate getTemplateDocument() {
		return templateDocument;
	}

	public void setTemplateDocument(DocumentTemplate templateDocument) {
		this.templateDocument = templateDocument;
	}

	public List<UserRecipient> getRecipientUsers() {
		return recipientUsers;
	}

	public void setRecipientUsers(List<UserRecipient> recipientUsers) {
		this.recipientUsers = recipientUsers;
	}

	public UserResponsible getResponsibleUser() {
		return responsibleUser;
	}

	public void setResponsibleUser(UserResponsible responsibleUser) {
		this.responsibleUser = responsibleUser;
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
		builder.append("Document [id=");
		builder.append(id);
		builder.append(", templateDocument=");
		builder.append(templateDocument);
		builder.append(", recipientUsers=");
		builder.append(recipientUsers);
		builder.append(", responsibleUser=");
		builder.append(responsibleUser);
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
