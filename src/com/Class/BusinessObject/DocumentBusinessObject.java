package com.Class.BusinessObject;

import java.util.List;

import com.Class.DataAccessObject.DocumentDataAccessObject;
import com.Class.DataTransferObject.Models.Document;
import com.Class.DataTransferObject.Models.UserRecipient;

public class DocumentBusinessObject {
	
	private DocumentDataAccessObject documentDAO = new DocumentDataAccessObject();
	
	public boolean create(Document document, List<UserRecipient> recipients) {
		documentDAO.create(document);
		
		document.setId(10);
		
		return documentDAO.associate(document, recipients);
	}
	
	public boolean update(Document document) {
		return documentDAO.update(document);
	}
	
	public boolean delete(Document document) {
		return documentDAO.delete(document);
	}
	
	public List<Document> get() {
		return documentDAO.get();
	}
	
	public Document find(Document document) {
		return documentDAO.find(document);
	}

}
