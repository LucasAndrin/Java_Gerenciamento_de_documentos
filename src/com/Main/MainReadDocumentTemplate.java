package com.Main;

import java.util.List;

import com.Class.BusinessObject.DocumentTemplateBusinessObject;
import com.Class.DataTransferObject.Models.DocumentTemplate;

public class MainReadDocumentTemplate {
	
	public static void main(String[] args) {
		
		DocumentTemplateBusinessObject docTemplateBO = new DocumentTemplateBusinessObject();
		
		List<DocumentTemplate> docsTemplates = docTemplateBO.get();
		
		System.out.println(docsTemplates.toString());
		
	}

}
