package com.Class.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.Class.DataTransferObject.Models.Document;
import com.Class.DataTransferObject.Models.DocumentTemplate;
import com.Class.DataTransferObject.Models.UserRecipient;
import com.Class.DataTransferObject.Models.UserResponsible;
import com.UtilClass.Connection.Conexao;

public class DocumentDataAccessObject extends DataAccessObject {
	
	protected String table = "documents";
	
	protected String relashionship = "documents_users";
    
    protected List<String> fillable = new ArrayList<String>(Arrays.asList(
    		"file",
    		"template_id",
    		"responsible_id"
	));
    
    protected List<String> fillableTimestamps = new ArrayList<String>(Arrays.asList(
    		"created_at",
    		"updated_at"
	));
    
    protected String deleteTimestamps = "deleted_at";
    
    public String getTable() {
		return table;
	}

	public List<String> getFillable() {
		return fillable;
	}

	public boolean create(Document document) {
    	try {
            Connection conn = Conexao.connect();
            StringBuilder strBuilder = new StringBuilder();
            
            strBuilder.append("INSERT INTO ");
            strBuilder.append(getTable());
            strBuilder.append(fillable.toString().replace('[', '(').replace(']', ')'));
            strBuilder.append(" VALUES (?, ?, ?)");
            
            PreparedStatement preparedStmt = conn.prepareStatement(strBuilder.toString());
            preparedStmt.setString(1, document.getFile());
            preparedStmt.setLong(2, document.getTemplateDocument().getId());
            preparedStmt.setLong(3, document.getResponsibleUser().getId());
            
            int affectedRows = preparedStmt.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("Creating document failed, no rows affected.");
            }
            
            ResultSet generatedKeys = preparedStmt.getGeneratedKeys();
            
            if (generatedKeys.next()) {
            	document.setId(generatedKeys.getLong(1));
            } else {
            	throw new SQLException("Creating document failed, no ID obtained.");
            }
            
            strBuilder = new StringBuilder();
	        strBuilder.append("INSERT INTO ");
	        strBuilder.append(relashionship);
	        strBuilder.append("(document_id, recipient_id)");
	        strBuilder.append(" VALUES ");
	        for (int count = 0; count < document.getRecipientUsers().size(); count++) {
				strBuilder.append("(?, ?)");
				if (count + 1 < document.getRecipientUsers().size()) {
					strBuilder.append(", ");
				}
			}
	        
	        preparedStmt = conn.prepareStatement(strBuilder.toString());
	        int count = 0;
	        for (UserRecipient userRecipient : document.getRecipientUsers()) {
	        	count++;
	        	preparedStmt.setLong(count, document.getId());
	        	count++;
				preparedStmt.setLong(count, userRecipient.getId());
			}
	        
	        preparedStmt.executeUpdate();
   
            preparedStmt.close();
            conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
	
	public boolean update(Document document) {
		try {
			Connection conn = Conexao.connect();
			StringBuilder strBuilder = new StringBuilder();
			
			Timestamp now = new Timestamp(System.currentTimeMillis());
			
			document.setUpdatedAt(now);
			
            strBuilder.append("UPDATE ");
            strBuilder.append(getTable());
            strBuilder.append(" SET file = ?, template_id = ?, responsible_id = ?, updated_at = now() WHERE ");
            strBuilder.append(primaryKey);
            strBuilder.append("= ?");
            
            PreparedStatement preparedStmt = conn.prepareStatement(strBuilder.toString());
            preparedStmt.setString(1, document.getFile());
            preparedStmt.setLong(2, document.getTemplateDocument().getId());
            preparedStmt.setLong(3, document.getResponsibleUser().getId());
            preparedStmt.setLong(4, document.getId());
            
            preparedStmt.executeUpdate();
            preparedStmt.close();
            conn.close();
            return true;
		} catch (Exception e) {
	       	 e.printStackTrace();
	         return false;
	    }
	}
	
	public boolean delete(Document document) {
		try {
			Connection conn = Conexao.connect();
			StringBuilder strBuilder = new StringBuilder();
            
			if ("".equals(deleteTimestamps)) {
				strBuilder.append("DELETE FROM ");
				strBuilder.append(getTable());
			} else {
				strBuilder.append("UPDATE ");
				strBuilder.append(getTable());
				strBuilder.append(" SET ");
				strBuilder.append(deleteTimestamps);
				strBuilder.append(" = now()");
			}
            
            strBuilder.append(" WHERE ");
            strBuilder.append(primaryKey);
            strBuilder.append("= ?");
            
            PreparedStatement preparedStmt = conn.prepareStatement(strBuilder.toString());
            preparedStmt.setLong(1, document.getId());
            
            preparedStmt.executeUpdate();
            preparedStmt.close();
            conn.close();
            return true;
		} catch (Exception e) {
	       	 e.printStackTrace();
	         return false;
	    }
	}
	
	public List<Document> get() {
        try {
            Connection conn = Conexao.connect();
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("SELECT * FROM ");
            strBuilder.append(getTable());

            PreparedStatement preparedStmt = conn.prepareStatement(strBuilder.toString());
            ResultSet rs = preparedStmt.executeQuery();
            List<Document> listObj = mountList(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public Document find(Document document) {
		try {
            Connection conn = Conexao.connect();
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("SELECT * FROM ");
            strBuilder.append(getTable());
            strBuilder.append(" WHERE ");
            strBuilder.append(primaryKey);
            strBuilder.append(" = ?");
            
            PreparedStatement ps = conn.prepareStatement(strBuilder.toString());
            ps.setLong(1, document.getId());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	Document obj = new Document();
            	
            	obj.setId(rs.getInt(1));
                obj.setFile(rs.getString(2));
                obj.setTemplateDocument(new DocumentTemplate(rs.getInt(3)));
                obj.setResponsibleUser(new UserResponsible(rs.getInt(4)));
                obj.setCreatedAt(rs.getTimestamp(5));
                obj.setUpdatedAt(rs.getTimestamp(6));
                obj.setDeletedAt(rs.getTimestamp(7));
                rs.close();
                ps.close();
                conn.close();
                
                return obj;
            } else {
                rs.close();
                ps.close();
                conn.close();
                
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public List<Document> mountList(ResultSet rs) {
		List<Document> listObj = new ArrayList<Document>();
        try {
            while (rs.next()) {
            	Document obj = new Document();
            	obj.setId(rs.getInt(1));
                obj.setFile(rs.getString(2));
                obj.setTemplateDocument(new DocumentTemplate(rs.getInt(3)));
                obj.setResponsibleUser(new UserResponsible(rs.getInt(4)));
                obj.setCreatedAt(rs.getTimestamp(5));
                obj.setUpdatedAt(rs.getTimestamp(6));
                obj.setDeletedAt(rs.getTimestamp(7));
                
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

}
