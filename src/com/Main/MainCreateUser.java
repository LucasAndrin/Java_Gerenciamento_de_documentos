package com.Main;

import com.Class.BusinessObject.UserBusinessObject;
import com.Class.DataTransferObject.Enums.UserType;
import com.Class.DataTransferObject.Models.User;
import com.Class.DataTransferObject.Models.UserAdmin;
import com.Class.DataTransferObject.Models.UserRecipient;
import com.Class.DataTransferObject.Models.UserResponsible;

public class MainCreateUser {

	public static void main(String[] args) {
		UserBusinessObject userBO = new UserBusinessObject();
		User userRecipient = new UserRecipient(), 
			userResponsible = new UserResponsible(),
			userAdmin = new UserAdmin();
		StringBuilder strBuilder;
		
//		Cria usuários destinatários
		for (int i = 0; i < 5; i++) {
			strBuilder = new StringBuilder();
			strBuilder.append("recipient");
			strBuilder.append(i);
			userRecipient.setName(strBuilder.toString());
			strBuilder.append("@gmail.com");
			userRecipient.setEmail(strBuilder.toString());
			userRecipient.setType(UserType.RECIPIENT);
			System.out.println(userBO.create(userRecipient));
		}

//		Cria usuários responsáveis
		for (int i = 0; i < 5; i++) {
			strBuilder = new StringBuilder();
			strBuilder.append("responsible");
			strBuilder.append(i);
			userResponsible.setName(strBuilder.toString());
			strBuilder.append("@gmail.com");
			userResponsible.setEmail(strBuilder.toString());
			userResponsible.setType(UserType.RESPONSIBLE);
			System.out.println(userBO.create(userResponsible));
		}
		
//		Cria usuários administradores
		for (int i = 0; i < 5; i++) {
			strBuilder = new StringBuilder();
			strBuilder.append("admin");
			strBuilder.append(i);
			userAdmin.setName(strBuilder.toString());
			strBuilder.append("@gmail.com");
			userAdmin.setEmail(strBuilder.toString());
			userAdmin.setType(UserType.ADMIN);
			System.out.println(userBO.create(userAdmin));
		}
	}

}
