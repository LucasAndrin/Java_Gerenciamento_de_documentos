package com.Main;

import com.Class.BusinessObject.UserBusinessObject;
import com.Class.DataTransferObject.Models.User;

public class MainUpdateUser {

	public static void main(String[] args) {
		
		UserBusinessObject userBO = new UserBusinessObject();
		
		User user = new User(4);
		System.out.println("Finding user...");
		user = userBO.find(user);
		System.out.println(user);
		
		if (!user.equals(null)) {
			user.setName("Super usuário atualizado!");
			
			System.out.println("Updating user...");
			System.out.println(user);
			System.out.println(userBO.update(user));
		}
		
	}

}
