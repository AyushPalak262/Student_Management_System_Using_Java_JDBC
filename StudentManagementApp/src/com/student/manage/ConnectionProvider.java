package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class ConnectionProvider {
    
    private static Connection con;
    
    public static Connection getConnection(){
        try{
        if(con==null){
        	//load the driver
           Class.forName("com.mysql.cj.jdbc.Driver");
           
           //Create the  connection
           String url="jdbc:mysql://localhost:3306/student_manage";
           String user="root";
           String password="Ayush@123";
           
           con=DriverManager.getConnection(url,user,password);
        }
        }catch (Exception e){
        e.printStackTrace();
        
    }
        return con;
    }
    
}
