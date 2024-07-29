package com.tech.blog.dao;

import com.tech.blog.entities.User;
import java.sql.*;
public class UserDao {
	
	private Connection con;
	public UserDao(Connection con) {
		this.con=con;
	}
	public boolean saveUser(User user) {
        boolean f = false;
        try {
            //user -->database

            String query = "insert into user(name,email,password,gender,about) values (?,?,?,?,?)";
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getGender());
            pstmt.setString(5, user.getAbout());

            pstmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;

    }

    public User getUserByEmailAndPassword(String email,String password) {
    	User user=null;
    	try {
    		String query="Select * from user where email=? and password=?";
    		PreparedStatement pstmt=this.con.prepareStatement(query);
    		pstmt.setString(1, email);
    		pstmt.setString(2,password);
    		ResultSet rs=pstmt.executeQuery();
    		while(rs.next()) {
    			user=new User();
    			user.setName(rs.getString("name"));
    			user.setId(rs.getInt("id"));
    			user.setEmail(rs.getString("email"));
    			user.setPassword(rs.getString("password"));
    			user.setAbout(rs.getString("about"));
    			user.setGender(rs.getString("gender"));
    			user.setDateTime(rs.getTimestamp("rdate"));
    			user.setProfile(rs.getString("profile"));
    			
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return user;
    	
    	
    }
    public boolean updateUser(User user) {
    	boolean f=false;
    	try {
    		String query="update user set name=?,email=?,password=?,gender=?,about=?,profile=? where id=?";
    		PreparedStatement psmt=con.prepareStatement(query);
    		psmt.setString(1, user.getName());
    		psmt.setString(2, user.getEmail());
    		psmt.setString(3, user.getPassword());
    		psmt.setString(4, user.getGender());
    		psmt.setString(5, user.getAbout());
    		psmt.setString(6, user.getProfile());
    		psmt.setInt(7, user.getId());
    		psmt.executeUpdate();
    		f=true;
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return f;
    }
    public User getUserByUserId(int userId) {
    	User user=null;
    	try {
    		String query="Select * from user where id=?";
    		PreparedStatement pstmt=this.con.prepareStatement(query);
    		pstmt.setInt(1, userId);

    		ResultSet rs=pstmt.executeQuery();
    		while(rs.next()) {
    			user=new User();
    			user.setName(rs.getString("name"));
    			user.setId(rs.getInt("id"));
    			user.setEmail(rs.getString("email"));
    			user.setPassword(rs.getString("password"));
    			user.setAbout(rs.getString("about"));
    			user.setGender(rs.getString("gender"));
    			user.setDateTime(rs.getTimestamp("rdate"));
    			user.setProfile(rs.getString("profile"));
    			
    		}
    		
    		
    		
    		
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    	return user;
    	
    }
    
    
    
   
}
