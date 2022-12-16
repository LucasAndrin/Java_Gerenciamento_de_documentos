package com.Main;

import java.util.List;

import com.Class.BusinessObject.UserBusinessObject;
import com.Class.DataTransferObject.Models.User;

public class MainReadUsers {
	
	public static void main(String[] args) {
		UserBusinessObject userBusinessObject = new UserBusinessObject();
		
		System.out.println("Getting users...");
		
		List<User> users = userBusinessObject.get();
		
		for (User user : users) {
			System.out.println(user.toString());
		}
		
		User user = new User(1);
		
		System.out.println("Finding user...");
		System.out.println(userBusinessObject.find(user));
		
		System.out.println("Finding user...");
		user.setId(6);
		System.out.println(userBusinessObject.find(user));
		
		System.out.println("Finding user...");
		user.setId(11);
		System.out.println(userBusinessObject.find(user));
		
		System.out.println("Finding user...");
		user.setId(3);
		System.out.println(userBusinessObject.find(user));
	}

}
