package com.ActionsMain;

import com.Class.BusinessObject.DocumentTemplateBusinessObject;
import com.Class.DataTransferObject.Models.DocumentTemplate;

public class MainDeleteDocumentTemplate {

	public static void main(String[] args) {
		
		DocumentTemplateBusinessObject docTemplateBO = new DocumentTemplateBusinessObject();
		DocumentTemplate docTemplate = docTemplateBO.find(new DocumentTemplate(1));
		
		System.out.println(docTemplate.toString());
		
		boolean result = docTemplateBO.delete(docTemplate);
		
		System.out.println(result);
	}

}
