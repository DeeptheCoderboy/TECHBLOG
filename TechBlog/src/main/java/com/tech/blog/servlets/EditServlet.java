package com.tech.blog.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

/**
 * Servlet implementation class EditServlet
 * 
 */
@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String userEmail=request.getParameter("user-email");
		String userName=request.getParameter("user_name");
		String userPassword=request.getParameter("user_password");
		String userAbout=request.getParameter("user_about");
		Part p=request.getPart("image");
		String imageName=p.getSubmittedFileName();
		HttpSession s=request.getSession();
		User user=(User)s.getAttribute("currentUser");
		user.setAbout(userEmail);
		user.setName(userName);
		user.setPassword(userPassword);
		user.setAbout(userAbout);
		String oldFile=user.getProfile();
		user.setProfile(imageName);
		UserDao userdao=new UserDao(ConnectionProvider.getConnection());
		boolean ans=userdao.updateUser(user);
		if(ans==true) {
			
			String path=request.getRealPath("/")+"pics"+File.separator+user.getProfile();
			String oldFilepath=request.getRealPath("/")+"pics"+File.separator+oldFile;
			if(!oldFile.equals("default.png")) {
			Helper.deleteFile(oldFilepath);
			}
				if(Helper.saveFile(p.getInputStream(), path)) {
					out.println("profile updated to db......");
					
					Message msg = new Message("Profile details Updated.....", "success", "alert-success");
				                s.setAttribute("msg", msg);
				}else {
					Message msg = new Message("Something Went Wrong.......", "error", "alert-danger");
		            s.setAttribute("msg", msg);
				}
			
		}
		else {
			out.println("Not Updated");
			Message msg = new Message("Something Went Wrong.......", "error", "alert-danger");
            s.setAttribute("msg", msg);
		}
		
		
		response.sendRedirect("profile.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
