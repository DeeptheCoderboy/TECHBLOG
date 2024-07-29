<%@page import="com.tech.blog.entities.User"%>
<%@page import="com.tech.blog.dao.*" %>
<%@page import="com.tech.blog.entities.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="css/mystyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
            .banner-background{
             clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 91%, 63% 100%, 22% 91%, 0 99%, 0 0);
            }
        </style>
</head>
<body>

        <!--navbar-->
        <%@include file="Normal_Navbar.jsp" %>

        <!--//banner-->


 
                    <div class="container-fluid p-0 m-0">

            <div class="jumbotron primary-background text-white banner-background">
                <div class="container">
                    <h3 class="display-3">Welcome to TechBlog </h3>

                    <p>Welcome to technical blog, world of technology
                        A programming language is a formal language, which comprises a set of instructions that produce various kinds of output. Programming languages are used in computer programming to implement algorithms.
                    </p>
                    <p>
                        Most programming languages consist of instructions for computers. There are programmable machines that use a set of specific instructions, rather than general programming languages. 
                    </p>

                    <a href="register_page.jsp" class="btn btn-outline-light btn-lg"> <span class="fa 	fa fa-user-plus"></span>  Start ! its Free</a>
                    <a href="login_page.jsp" class="btn btn-outline-light btn-lg"> <span class="fa fa-user-circle fa-spin"></span>  Login</a>

                </div>
            </div>






        </div>






       



        <!--//cards-->

        <div class="container">

            <div class="row mb-2">

                
                   
                
                 <%
        	
        	
        	
        	
        	
        	
        	    
        	    Thread.sleep(1000);
        	    PostDao d = new PostDao(ConnectionProvider.getConnection());
        	    
        	    Integer x=(Integer)session.getAttribute("cid");
        	    List<Post> posts = null;
        	    if (x == null||x==0) {
        	        posts = d.getAllPost();
        	    } else {
        	        posts = d.getPostByCatId(x);
        	        session.setAttribute("cid", 0);
        	    }
        	    
        	    if (posts.size() == 0) {
        	        out.println("<h3 class='display-3 text-center'>No Posts in this category..</h3>");
        	        return;
        	    }
        	    
        	      
        	        
        	        for (Post p : posts) {	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
    %>    
                      <div class="col-md-4 mb-2">
                      <div class="card" >
                
                        <div class="card-body">
                            <h5 class="card-title"><%= p.getpTitle()%></h5>
                            <p class="card-text"><%= p.getpContent()%></p>
                            
                            <%
                            
                            User user=(User)session.getAttribute("currentUser");
                            if(user!=null){%>
                            <a href="profile.jsp" class="btn primary-background text-white">Read more</a>
                            <%} %>
                            <%if(user==null){ %>
                            <a href="login_page.jsp" class="btn primary-background text-white">Read more</a>
                           <%} %>
                            
                            
                            
                        </div>
                    </div>
                    </div>
                    <%} %>
                    </div>
                    </div>
                    
             <!--    
                <div class="col-md-4">
                    <div class="card" >

                        <div class="card-body">
                            <h5 class="card-title">Java Programming</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn primary-background text-white">Read more</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card" >

                        <div class="card-body">
                            <h5 class="card-title">Java Programming</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn primary-background text-white">Read more</a>
                        </div>
                    </div>
                </div>


            </div>




            <div class="row">

                <div class="col-md-4">
                    <div class="card" >

                        <div class="card-body">
                            <h5 class="card-title">Java Programming</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn primary-background text-white">Read more</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card" >

                        <div class="card-body">
                            <h5 class="card-title">Java Programming</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn primary-background text-white">Read more</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card" >

                        <div class="card-body">
                            <h5 class="card-title">Java Programming</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn primary-background text-white">Read more</a>
                        </div>
                    </div>
                </div>


            </div>

        </div>

              -->


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="app/jquery-3.7.1.js" type="text/javascript"></script>
<script src="Js/myjs.js" type="text/javascript"></script>


</body>
</html>