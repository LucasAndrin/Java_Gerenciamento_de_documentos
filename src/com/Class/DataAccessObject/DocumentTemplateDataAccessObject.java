package com.Class.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.Class.DataTransferObject.Models.DocumentTemplate;
import com.Class.DataTransferObject.Models.User;
import com.UtilClass.Connection.Conexao;

public class DocumentTemplateDataAccessObject extends DataAccessObject {
	
protected String table = "templates";
    
    protected List<String> fillable = new ArrayList<String>(Arrays.asList(
    		"name",
    		"descript",
    		"created_by"
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

	public boolean create(DocumentTemplate documentTemplate) {
    	try {
            Connection conn = Conexao.connect();
            StringBuilder strBuilder = new StringBuilder();
            
            strBuilder.append("INSERT INTO ");
            strBuilder.append(getTable());
            strBuilder.append(fillable.toString().replace('[', '(').replace(']', ')'));
            strBuilder.append(" VALUES (?, ?, ?)");
            
            PreparedStatement preparedStmt = conn.prepareStatement(strBuilder.toString());
            preparedStmt.setString(1, documentTemplate.getName());
            preparedStmt.setString(2, documentTemplate.getDescript());
            preparedStmt.setLong(3, documentTemplate.getCreatedBy().getId());
            
            preparedStmt.executeUpdate();
            preparedStmt.close();
            conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
	
	public boolean update(DocumentTemplate documentTemplate) {
		try {
			Connection conn = Conexao.connect();
			StringBuilder strBuilder = new StringBuilder();
			
			Timestamp now = new Timestamp(System.currentTimeMillis());
			
			documentTemplate.setUpdatedAt(now);
			
            strBuilder.append("UPDATE ");
            strBuilder.append(getTable());
            strBuilder.append(" SET name = ?, descript = ?, created_by = ?, updated_at = now() WHERE ");
            strBuilder.append(primaryKey);
            strBuilder.append("= ?");
            
            PreparedStatement preparedStmt = conn.prepareStatement(strBuilder.toString());
            preparedStmt.setString(1, documentTemplate.getName());
            preparedStmt.setString(2, documentTemplate.getDescript());
            preparedStmt.setLong(3, documentTemplate.getCreatedBy().getId());
            preparedStmt.setLong(4, documentTemplate.getId());
            
            preparedStmt.executeUpdate();
            preparedStmt.close();
            conn.close();
            return true;
		} catch (Exception e) {
	       	 e.printStackTrace();
	         return false;
	    }
	}
	
	public boolean delete(DocumentTemplate documentTemplate) {
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
            preparedStmt.setLong(1, documentTemplate.getId());
            
            preparedStmt.executeUpdate();
            preparedStmt.close();
            conn.close();
            return true;
		} catch (Exception e) {
	       	 e.printStackTrace();
	         return false;
	    }
	}
	
	public List<DocumentTemplate> get() {
        try {
            Connection conn = Conexao.connect();
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("SELECT * FROM ");
            strBuilder.append(getTable());

            PreparedStatement preparedStmt = conn.prepareStatement(strBuilder.toString());
            ResultSet rs = preparedStmt.executeQuery();
            List<DocumentTemplate> listObj = mountList(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public DocumentTemplate find(DocumentTemplate documentTemplate) {
		try {
            Connection conn = Conexao.connect();
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("SELECT * FROM ");
            strBuilder.append(getTable());
            strBuilder.append(" WHERE ");
            strBuilder.append(primaryKey);
            strBuilder.append(" = ?");
            
            PreparedStatement ps = conn.prepareStatement(strBuilder.toString());
            ps.setLong(1, documentTemplate.getId());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	DocumentTemplate obj = new DocumentTemplate();
            	
                obj.setId(rs.getInt(1));
                obj.setDescript(rs.getString(2));
                obj.setName(rs.getString(3));
                obj.setCreatedBy(new User(rs.getLong(4)));
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
	
	public List<DocumentTemplate> mountList(ResultSet rs) {
		List<DocumentTemplate> listObj = new ArrayList<DocumentTemplate>();
        try {
            while (rs.next()) {
            	DocumentTemplate obj = new DocumentTemplate();
            	obj.setId(rs.getInt(1));
                obj.setDescript(rs.getString(2));
                obj.setName(rs.getString(3));
                obj.setCreatedBy(new User(rs.getLong(4)));
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
