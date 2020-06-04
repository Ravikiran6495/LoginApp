package com.hefshine.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hefshine.bean.User;

public class UserDao {
	
	public boolean checkUser(User user)
	{
		boolean status=false;
		
		String query="SELECT username FROM student1 user WHERE username = ? AND password = ?";
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hefshine","root","root");
		
		PreparedStatement pst=con.prepareStatement(query);
		
		pst.setString(1, user.getUsername());
		pst.setString(2, user.getPassword());
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{
			System.out.println("Record found");
			status=true;
		}
		
		con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		
		return status;
		
	}


}
