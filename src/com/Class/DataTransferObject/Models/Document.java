package com.Class.DataTransferObject.Models;

import java.time.LocalDate;
import java.util.List;

public class Document {
	
	private long id;
	
	private DocumentTemplate templateDocument;
	
	private List<UserRecipient> recipientUsers;
	
	private UserResponsible responsibleUser;
	
	private LocalDate createdAt;
	
	private LocalDate updatedAt;
	
	private LocalDate deletedAt;
	
	public Document(DocumentTemplate templateDocument, List<UserRecipient> recipientUsers, UserResponsible responsibleUser) {
		setTemplateDocument(templateDocument);
		setRecipientUsers(recipientUsers);
		setResponsibleUser(responsibleUser);
	}

	public Document(long id, DocumentTemplate templateDocument, List<UserRecipient> recipientUsers, UserResponsible responsibleUser, LocalDate createdAt, LocalDate updatedAt, LocalDate deletedAt) {
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

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDate getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDate deletedAt) {
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
