package com.ActionsMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.Class.BusinessObject.DocumentBusinessObject;
import com.Class.DataTransferObject.Models.Document;
import com.Class.DataTransferObject.Models.DocumentTemplate;
import com.Class.DataTransferObject.Models.UserRecipient;
import com.Class.DataTransferObject.Models.UserResponsible;

public class MainCreateDocument {
	
	public static void main(String[] args) {
		
		DocumentBusinessObject documentBO = new DocumentBusinessObject();
		
		UserResponsible responsible = new UserResponsible(6);
		DocumentTemplate template = new DocumentTemplate(2);
		
		Document doc = new Document();
		doc.setFile("caminho/arquivo");
		doc.setResponsibleUser(responsible);
		doc.setTemplateDocument(template);
		
		UserRecipient[] recipientsArray = {
			new UserRecipient(1),
			new UserRecipient(2)
		};
		
		List<UserRecipient> recipients = new ArrayList<UserRecipient>(Arrays.asList(recipientsArray));
		
		boolean result = documentBO.create(doc, recipients);
		
		System.out.println(result);

	}

}
