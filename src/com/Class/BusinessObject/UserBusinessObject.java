package com.Class.BusinessObject;

import java.util.List;

import com.Class.DataAccessObject.UserDataAccessObject;
import com.Class.DataTransferObject.Models.User;

public class UserBusinessObject {
	
	private UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
	
	public boolean create(User user) {
		return userDataAccessObject.create(user);
	}
	
	public int update(User user) {
		return userDataAccessObject.update(user);
	}
	
	public boolean delete(User user) {
		return userDataAccessObject.delete(user);
	}
	
	public List<User> get() {
		return userDataAccessObject.get();
	}
	
	public User find(User user) {
		return userDataAccessObject.find(user);
	}

}
