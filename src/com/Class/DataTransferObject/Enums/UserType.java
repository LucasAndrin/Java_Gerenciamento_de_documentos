package com.Class.DataTransferObject.Enums;

public enum UserType {
	RECIPIENT(1),
	RESPONSIBLE(2),
	ADMIN(3);
	
	private final int type;
	
	UserType(int type) {
		this.type = type;
	}
	
	public int getValue() {
		return type;
	}
}
