package com.Class.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.Class.DataTransferObject.Enums.UserType;
import com.Class.DataTransferObject.Models.User;
import com.Class.DataTransferObject.Models.UserAdmin;
import com.Class.DataTransferObject.Models.UserRecipient;
import com.Class.DataTransferObject.Models.UserResponsible;
import com.UtilClass.Connection.Conexao;

public class UserDataAccessObject extends DataAccessObject {
	
    protected String table = "users";
    
    protected List<String> fillable = new ArrayList<String>(Arrays.asList(
    		"name",
    		"email",
    		"type"
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

	public boolean create(User user) {
    	try {
            Connection conn = Conexao.connect();
            StringBuilder strBuilder = new StringBuilder();
            
            strBuilder.append("INSERT INTO ");
            strBuilder.append(getTable());
            strBuilder.append(fillable.toString().replace('[', '(').replace(']', ')'));
            strBuilder.append(" VALUES (?, ?, ?)");
            
            PreparedStatement preparedStmt = conn.prepareStatement(strBuilder.toString());
            preparedStmt.setString(1, user.getName());
            preparedStmt.setString(2, user.getEmail());
            preparedStmt.setInt(3, user.getType().getValue());
            
            preparedStmt.executeUpdate();
            preparedStmt.close();
            conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
	
	public int update(User user) {
		try {
			Connection conn = Conexao.connect();
			StringBuilder strBuilder = new StringBuilder();
			
			Timestamp now = new Timestamp(System.currentTimeMillis());
			
			user.setUpdatedAt(now);
			
            strBuilder.append("UPDATE ");
            strBuilder.append(getTable());
            strBuilder.append(" SET name = ?, email = ?, type = ?, updated_at = now() WHERE ");
            strBuilder.append(primaryKey);
            strBuilder.append("= ? ");
            if (!"".equals(deleteTimestamps)) {
            	strBuilder.append(" AND ");
            	strBuilder.append(deleteTimestamps);
            	strBuilder.append(" IS NULL ");
            }
            
            PreparedStatement preparedStmt = conn.prepareStatement(strBuilder.toString());
            preparedStmt.setString(1, user.getName());
            preparedStmt.setString(2, user.getEmail());
            preparedStmt.setInt(3, user.getType().getValue());
            preparedStmt.setLong(4, user.getId());
            
            int affectedRows = preparedStmt.executeUpdate();
            
            preparedStmt.close();
            conn.close();
            
            return affectedRows;
		} catch (Exception e) {
	       	 e.printStackTrace();
	         return 0;
	    }
	}
	
	public boolean delete(User user) {
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
            preparedStmt.setLong(1, user.getId());
            
            preparedStmt.executeUpdate();
            preparedStmt.close();
            conn.close();
            return true;
		} catch (Exception e) {
	       	 e.printStackTrace();
	         return false;
	    }
	}
	
	public List<User> get() {
        try {
            Connection conn = Conexao.connect();
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("SELECT * FROM ");
            strBuilder.append(getTable());
            if (!"".equals(deleteTimestamps)) {
            	strBuilder.append(" WHERE ");
            	strBuilder.append(deleteTimestamps);
            	strBuilder.append(" IS NULL ");
            }
            System.out.println(strBuilder.toString());
            PreparedStatement preparedStmt = conn.prepareStatement(strBuilder.toString());
            ResultSet rs = preparedStmt.executeQuery();
            List<User> listObj = mountList(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public User find(User user) {
		try {
            Connection conn = Conexao.connect();
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("SELECT * FROM ");
            strBuilder.append(getTable());
            strBuilder.append(" WHERE ");
            strBuilder.append(primaryKey);
            strBuilder.append(" = ?");
            if (!"".equals(deleteTimestamps)) {
            	strBuilder.append(" AND ");
            	strBuilder.append(deleteTimestamps);
            	strBuilder.append(" IS NULL ");
            }
            
            PreparedStatement ps = conn.prepareStatement(strBuilder.toString());
            ps.setLong(1, user.getId());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
            	User obj;
            	int userType = rs.getInt(4);
            	if (UserType.RECIPIENT.getValue() == userType) {
            		obj = new UserRecipient();
            	} else if (UserType.ADMIN.getValue() == userType) {
            		obj = new UserAdmin();
            	} else if (UserType.RESPONSIBLE.getValue() == userType) {
            		obj = new UserResponsible();
            	} else {
            		obj = new UserAdmin();
            	}
            	
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setEmail(rs.getString(3));
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
	
	public List<User> mountList(ResultSet rs) {
		List<User> listObj = new ArrayList<User>();
        try {
            while (rs.next()) {
            	User obj;
            	int userType = rs.getInt(4);
            	if (UserType.RECIPIENT.getValue() == userType) {
            		obj = new UserRecipient();
            	} else if (UserType.ADMIN.getValue() == userType) {
            		obj = new UserAdmin();
            	} else if (UserType.RESPONSIBLE.getValue() == userType) {
            		obj = new UserResponsible();
            	} else {
            		obj = new UserAdmin();
            	}
            	
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setEmail(rs.getString(3));
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
