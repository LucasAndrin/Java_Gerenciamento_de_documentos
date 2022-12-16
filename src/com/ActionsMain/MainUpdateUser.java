package com.ActionsMain;

import com.Class.BusinessObject.UserBusinessObject;
import com.Class.DataTransferObject.Models.User;

public class MainUpdateUser {

	public static void main(String[] args) {
		
		UserBusinessObject userBO = new UserBusinessObject();
		
		User user = new User(3);
		System.out.println("searching user...");
		user = userBO.find(user);
		System.out.println(user.toString());
		
		user.setName("João Lindo");
		
		boolean result = userBO.update(user);
		
		System.out.println(result);
		
	}

}
