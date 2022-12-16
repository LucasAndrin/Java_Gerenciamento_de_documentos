package com.Main;

import com.Class.BusinessObject.DocumentTemplateBusinessObject;
import com.Class.DataTransferObject.Models.DocumentTemplate;

public class MainUpdateDocumentTemplate {

	public static void main(String[] args) {
		
		DocumentTemplateBusinessObject docTemplateBO = new DocumentTemplateBusinessObject();
		DocumentTemplate docTemplate = docTemplateBO.find(new DocumentTemplate(1));
		
		System.out.println(docTemplate.toString());
		
		docTemplate.setDescript("SUPER TESTE DE UPDATE");
		
		boolean result = docTemplateBO.update(docTemplate);
		
		System.out.println(result);

	}

}
