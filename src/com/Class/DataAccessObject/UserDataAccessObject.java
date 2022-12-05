package com.Class.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.Class.DataTransferObject.Enums.UserType;
import com.Class.DataTransferObject.Models.User;
import com.UtilClass.Connection.Conexao;

public class UserDataAccessObject extends DataAcessObject {
	
    protected String table = "users";
    
    protected List<String> fillable = new ArrayList<String>(Arrays.asList(
    		"name",
    		"email",
    		"type",
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
            Connection conn = Conexao.conectar();
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("INSERT INTO ");
            strBuilder.append(getTable());
            strBuilder.append(fillable.toString().replace('[', '(').replace(']', ')'));
            strBuilder.append(" VALUES (?, ?, ?, ?, ?)");
            
            PreparedStatement preparedStmt = conn.prepareStatement(strBuilder.toString());
            preparedStmt.setString(1, user.getName());
            preparedStmt.setString(2, user.getEmail());
            preparedStmt.setInt(3, user.getType().getValue());
            preparedStmt.setTimestamp(4, (Timestamp) new Date());
            preparedStmt.setTimestamp(5, (Timestamp) new Date());
            
            preparedStmt.executeUpdate();
            preparedStmt.close();
            conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
	
	public boolean update(User user) {
		try {
			Connection conn = Conexao.conectar();
			StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("UPDATE ");
            strBuilder.append(getTable());
            strBuilder.append(" SET name = ?, email = ?, type = ?, updated_at = ? WHERE ");
            strBuilder.append(primaryKey);
            strBuilder.append("= ?");
            
            PreparedStatement preparedStmt = conn.prepareStatement(strBuilder.toString());
            preparedStmt.setString(1, user.getName());
            preparedStmt.setString(2, user.getEmail());
            preparedStmt.setInt(3, user.getType().getValue());
            preparedStmt.setTimestamp(4, (Timestamp) new Date());
            preparedStmt.setLong(5, user.getId());
            
            preparedStmt.executeUpdate();
            preparedStmt.close();
            conn.close();
            return true;
		} catch (Exception e) {
	       	 e.printStackTrace();
	         return false;
	    }
	}
	
	public boolean delete(User user) {
		try {
			Connection conn = Conexao.conectar();
			StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("DELETE FROM ");
            strBuilder.append(getTable());
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
            Connection conn = Conexao.conectar();
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("SELECT * FROM ");
            strBuilder.append(getTable());

            PreparedStatement ps = conn.prepareStatement(strBuilder.toString());
            ResultSet rs = ps.executeQuery();
            List<User> listObj = mountList(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public User find(User user) {
		try {
            Connection conn = Conexao.conectar();
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("SELECT * FROM ");
            strBuilder.append(getTable());
            strBuilder.append("WHERE ");
            strBuilder.append(primaryKey);
            strBuilder.append(" = ?");
            
            PreparedStatement ps = conn.prepareStatement(strBuilder.toString());
            ResultSet rs = ps.executeQuery();
            ps.close();
            conn.close();

            if (rs.next()) {
            	User obj = new User();
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setEmail(rs.getString(3));
                
                for (UserType type : UserType.values()) {
        			if (type.getValue() == rs.getInt(4)) {
        				obj.setType(type);
        			}
        		}
                
                obj.setCreatedAt(rs.getTimestamp(5));
                obj.setUpdatedAt(rs.getTimestamp(6));
                obj.setDeletedAt(rs.getTimestamp(7));
                rs.close();
                
                return obj;
            } else {
                rs.close();
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
                User obj = new User();
                obj.setId(rs.getInt(1));
                obj.setName(rs.getString(2));
                obj.setEmail(rs.getString(3));
                
                for (UserType type : UserType.values()) {
        			if (type.getValue() == rs.getInt(4)) {
        				obj.setType(type);
        			}
        		}
                
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
