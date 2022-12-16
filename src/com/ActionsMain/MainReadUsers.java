package com.ActionsMain;

import java.util.List;

import com.Class.DataAccessObject.UserDataAccessObject;
import com.Class.DataTransferObject.Models.User;

public class MainReadUsers {
	
	public static void main(String[] args) {
		UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
		
		List<User> users = userDataAccessObject.get();
		
		for (User user : users) {
			System.out.println(user.toString());
		}
		
	}

}
