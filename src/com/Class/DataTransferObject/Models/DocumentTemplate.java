package com.Class.DataTransferObject.Models;

import java.time.LocalDate;

public class DocumentTemplate {
	
	private long id;
	
	private String name;
	
	private String descript;
	
	private UserAdmin createdBy;
	
	private LocalDate createdAt;
	
	private LocalDate updatedAt;
	
	private LocalDate deletedAt;
	
	public DocumentTemplate(String name, String descript, UserAdmin createdBy) {
		setName(name);
		setDescript(descript);
		setCreatedBy(createdBy);
	}	

	public DocumentTemplate(long id, String name, String descript, UserAdmin createdBy, LocalDate createdAt, LocalDate updatedAt, LocalDate deletedAt) {
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

	public UserAdmin getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserAdmin createdBy) {
		this.createdBy = createdBy;
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
 