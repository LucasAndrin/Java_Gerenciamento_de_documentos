package com.Class.DataTransferObject.Models;

import java.sql.Timestamp;

public class DocumentTemplate {
	
	private long id;
	
	private String name;
	
	private String descript;
	
	private User createdBy;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;
	
	private Timestamp deletedAt;
	
	public DocumentTemplate() {
		
	}
	
	public DocumentTemplate(long id) {
		setId(id);
	}
	
	public DocumentTemplate(String name, String descript, UserAdmin createdBy) {
		setName(name);
		setDescript(descript);
		setCreatedBy(createdBy);
	}	

	public DocumentTemplate(long id, String name, String descript, UserAdmin createdBy, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		setId(id);
		setName(name);
		setDescript(descript);
		setCreatedBy(createdBy);
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

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
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
		builder.append("DocumentTemplate [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", descript=");
		builder.append(descript);
		builder.append(", createdBy=");
		builder.append(createdBy);
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
 