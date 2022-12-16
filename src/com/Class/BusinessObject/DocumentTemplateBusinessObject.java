package com.Class.BusinessObject;

import java.util.List;

import com.Class.DataAccessObject.DocumentTemplateDataAccessObject;
import com.Class.DataTransferObject.Models.DocumentTemplate;

public class DocumentTemplateBusinessObject {

	private DocumentTemplateDataAccessObject documentTemplateDataAccessObject = new DocumentTemplateDataAccessObject();
	
	public boolean create(DocumentTemplate documentTemplate) {
		return documentTemplateDataAccessObject.create(documentTemplate);
	}
	
	public boolean update(DocumentTemplate documentTemplate) {
		return documentTemplateDataAccessObject.update(documentTemplate);
	}
	
	public boolean delete(DocumentTemplate documentTemplate) {
		return documentTemplateDataAccessObject.delete(documentTemplate);
	}
	
	public List<DocumentTemplate> get() {
		return documentTemplateDataAccessObject.get();
	}
	
	public DocumentTemplate find(DocumentTemplate documentTemplate) {
		return documentTemplateDataAccessObject.find(documentTemplate);
	}
	
}
