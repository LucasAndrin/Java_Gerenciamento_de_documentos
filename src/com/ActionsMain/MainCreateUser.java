package com.ActionsMain;

import com.Class.BusinessObject.UserBusinessObject;
import com.Class.DataTransferObject.Enums.UserType;
import com.Class.DataTransferObject.Models.User;
import com.Class.DataTransferObject.Models.UserAdmin;
import com.Class.DataTransferObject.Models.UserRecipient;
import com.Class.DataTransferObject.Models.UserResponsible;

public class MainCreateUser {

	public static void main(String[] args) {
		UserBusinessObject userBO = new UserBusinessObject();
		User user = new User();
		UserRecipient userRecipient = new UserRecipient();
		UserResponsible userResponsible = new UserResponsible();
		UserAdmin userAdmin = new UserAdmin();

		user.setName("Teste1");
		user.setEmail("teste1@gmail.com");
		user.setType(UserType.RECIPIENT);

		System.out.println(userBO.create(user));
		
		user.setName("Teste2");
		user.setEmail("teste2@gmail.com");
		user.setType(UserType.RESPONSIBLE);
		
		System.out.println(userBO.create(user));

		user.setName("Teste3");
		user.setEmail("teste3@gmail.com");
		user.setType(UserType.ADMIN);

		System.out.println(userBO.create(user));
		
		userRecipient.setName("RECIPIENT");
		userRecipient.setEmail("RECIPIENT@gmail.com");
		userRecipient.setType(UserType.RECIPIENT);
		
		System.out.println(userBO.create(userRecipient));
		
		userResponsible.setName("RESPONSIBLE");
		userResponsible.setEmail("RESPONSIBLE@gmail.com");
		userResponsible.setType(UserType.RESPONSIBLE);
		
		System.out.println(userBO.create(userResponsible));
		
		userAdmin.setName("ADMIN");
		userAdmin.setEmail("ADMIN@gmail.com");
		userAdmin.setType(UserType.ADMIN);
		
		System.out.println(userBO.create(userAdmin));
	}

}
