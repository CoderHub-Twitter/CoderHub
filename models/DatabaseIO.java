package models;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseIO {
    
    private static String url="jdbc:mysql://localhost:3306/estates";
    private static String username="root";
    private static String password="";
    
    private String registerUserSql="insert into users(email,password) values(?,?)";
    private String authenticateUserSql="select * from  users where email=? and password=?";
    
   private static Connection Connect(){
        try{
            Class.forName( "com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection(url,username,password);
            System.out.println("Connection successfull");
            Statement statement = connection.createStatement();
            return connection;
       }catch(Exception e)
       {
           System.out.println("Error connecting to database");
           e.printStackTrace();
       }
        return null;
   }
   
   public void RegisterUser(User user ) {
	 try {
		PreparedStatement preparedStatement = Connect().prepareStatement(registerUserSql);
		
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2, user.getPassword());
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
	 
	 public boolean authenticateUser(User user ) {
		 boolean status = false;
		 try {
			PreparedStatement preparedStatement = Connect().prepareStatement(authenticateUserSql);
			
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			
			ResultSet rs=preparedStatement.executeQuery();
			
			if(rs.next()) {
				status=true;
				
			}
			else {
				status=false;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return status;
	   
	     
   }
   
   	


   
}