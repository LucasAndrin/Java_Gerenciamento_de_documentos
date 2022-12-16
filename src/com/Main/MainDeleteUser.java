package com.Main;

import com.Class.BusinessObject.UserBusinessObject;
import com.Class.DataTransferObject.Models.User;

public class MainDeleteUser {

	public static void main(String[] args) {
		
		UserBusinessObject userBO = new UserBusinessObject();
		
		User user = new User(3);
		System.out.println("Finding user...");
		user = userBO.find(user);
		System.out.println(user.toString());
		
		System.out.println("Deleting user...");
		boolean result = userBO.delete(user);
		System.out.println(result);
		
	}

}
