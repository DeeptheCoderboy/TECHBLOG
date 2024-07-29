
package com.tech.blog.dao;

import com.tech.blog.entities.Category;
import com.tech.blog.entities.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PostDao {

    Connection con;

    public PostDao(Connection con) {
        this.con = con;
    }

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> list = new ArrayList<>();

        try {

            String q = "select * from categories";
            Statement st = this.con.createStatement();
            ResultSet set = st.executeQuery(q);
            while (set.next()) {
                int cid = set.getInt("cid");
                String name = set.getString("name");
                String description = set.getString("description");
                Category c = new Category(cid, name, description);
                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public boolean saveCategory(Category c) {
    	boolean f = false;
        try {

            String q = "insert into categories(name,description) values(?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getDescription());
           
            pstmt.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    	
    }
    
    
    
    
    
    
    
    public boolean savePost(Post p) {
    	  boolean f = false;
          try {

              String q = "insert into posts(pTitle,pContent,pCode,pPic,catId,userId) values(?,?,?,?,?,?)";
              PreparedStatement pstmt = con.prepareStatement(q);
              pstmt.setString(1, p.getpTitle());
              pstmt.setString(2, p.getpContent());
              pstmt.setString(3, p.getpCode());
              pstmt.setString(4, p.getpPic());
              pstmt.setInt(5, p.getCatId());
              pstmt.setInt(6, p.getUserId());
              pstmt.executeUpdate();
              f = true;

          } catch (Exception e) {
              e.printStackTrace();
          }

          return f;
    	
    }
    
    
    public List<Post> getAllPost(){
    	List<Post> li=new ArrayList<>();
    
    	try {
    
    	String Query="Select * from posts order by pid desc";
    	PreparedStatement pt=con.prepareStatement(Query);
    	ResultSet rs=pt.executeQuery();
    	while(rs.next()) {
    		int pid=rs.getInt("pid");
    		String pTitle=rs.getString("pTitle");
    		String pContent=rs.getString("pContent");
    		String pCode=rs.getString("pCode");
    	    String pPic=rs.getString("pPic");
    	    Timestamp pDate=rs.getTimestamp("pDate");
    	    int catId=rs.getInt("catId");
    	    int userId=rs.getInt("userId");
    	    Post p=new Post(pid,  pTitle, pContent, pCode,  pPic,  pDate, catId, userId);
    	    li.add(p);
    		
    		
    	}
    	
    	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    	return li;
    }
    public List<Post> getPostByCatId(int catId){
    	List<Post> li=new ArrayList<>();
        
    	try {
    
    	String Query="Select * from posts where catId=?";
    	PreparedStatement pt=con.prepareStatement(Query);
    	pt.setInt(1, catId);
    	ResultSet rs=pt.executeQuery();
    	while(rs.next()) {
    		int pid=rs.getInt("pid");
    		String pTitle=rs.getString("pTitle");
    		String pContent=rs.getString("pContent");
    		String pCode=rs.getString("pCode");
    	    String pPic=rs.getString("pPic");
    	    Timestamp pDate=rs.getTimestamp("pDate");
    	   
    	    int userId=rs.getInt("userId");
    	    Post p=new Post(pid,  pTitle, pContent, pCode,  pPic,  pDate, catId, userId);
    	    li.add(p);
    		
    		
    	}
    	
    	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    	return li;
    	
    }
    public Post getPostByPostId(int postId) {
    	Post post=null;
    	try {
    		String Query="Select * from posts where pid=?";
    		PreparedStatement pt=con.prepareStatement(Query);
    		pt.setInt(1, postId);
    		ResultSet rs=pt.executeQuery();
    		while(rs.next()) {
        		int pid=rs.getInt("pid");
        		String pTitle=rs.getString("pTitle");
        		String pContent=rs.getString("pContent");
        		String pCode=rs.getString("pCode");
        	    String pPic=rs.getString("pPic");
        	    Timestamp pDate=rs.getTimestamp("pDate");
        	    int catId=rs.getInt("catId");
        	    int userId=rs.getInt("userId");
        	   post=new Post(pid,  pTitle, pContent, pCode,  pPic,  pDate, catId, userId);
    		
    	}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return post;
    	
    }
}

