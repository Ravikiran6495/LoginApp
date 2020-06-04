package com.hefshine.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hefshine.Dao.UserDao;
import com.hefshine.bean.User;




@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			PrintWriter PW=response.getWriter();
			
			UserDao ud=new UserDao();
			
			String username=request.getParameter("username");
			String password=request.getParameter("passwprd");

			
			User user=new User(username, password);
			
			if(ud.checkUser(user))
			{
				
				
				PW.write("Welcome "+username);
			}
			else
			{
				PW.write("Sorry  your password is wrong....!");
			}
			
		}

	}


