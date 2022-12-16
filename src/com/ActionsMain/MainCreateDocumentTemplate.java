package com.ActionsMain;

import com.Class.BusinessObject.DocumentTemplateBusinessObject;
import com.Class.BusinessObject.UserBusinessObject;
import com.Class.DataTransferObject.Models.DocumentTemplate;
import com.Class.DataTransferObject.Models.User;
import com.Class.DataTransferObject.Models.UserAdmin;

public class MainCreateDocumentTemplate {

	public static void main(String[] args) {
		
		DocumentTemplateBusinessObject docTemplateBO = new DocumentTemplateBusinessObject();
		UserBusinessObject userBO = new UserBusinessObject();
		DocumentTemplate docTemplate = new DocumentTemplate();
		User user = new UserAdmin(6);
		
		user = userBO.find(user);
		
		docTemplate.setName("Primeiro Template de Documento!");
		docTemplate.setDescript("Descrição");
		docTemplate.setCreatedBy(user);
		
		
		boolean result = docTemplateBO.create(docTemplate);
		
		System.out.println(result);
	}

}
