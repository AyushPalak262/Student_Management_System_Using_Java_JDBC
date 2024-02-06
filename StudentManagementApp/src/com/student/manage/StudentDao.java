package com.student.manage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	public static boolean insertStudentDB(Student st) {
		boolean f=false;
		 try{	
			 	//jdbc connection
			    Connection con =ConnectionProvider.getConnection();
			    //insert query
			    String q="insert into students(sname,sphone,scity) values (?,?,?)";
			    //prepare statement
			    PreparedStatement pstmt=con.prepareStatement(q);
			    //set the parameter
			    pstmt.setString(1,st.getStudentName());
			    pstmt.setString(2,st.getStudentPhone());
			    pstmt.setString(3,st.getStudentCity());
			    //execute
			    pstmt.executeUpdate();	
			    f=true;
			    
			}catch (Exception e){
			    e.printStackTrace();
			} 
		 return f;
	}

	public static boolean deleteStudent(int userId) {
		boolean f=false;
		 try{	
			 	//jdbc connection
			    Connection con =ConnectionProvider.getConnection();
			    //write delete query
			    String q="delete from students where sid=?";
			    //prepare statement
			    PreparedStatement pstmt=con.prepareStatement(q);
			    //set the parameter
			    pstmt.setInt(1,userId);
			   
			    //execute
			    pstmt.executeUpdate();	
			    f=true;
			    
			}catch (Exception e){
			    e.printStackTrace();
			} 
		 return f;
		
	}

	public static void showAllStudent() {
		 try{
	            Connection con=ConnectionProvider.getConnection();
	            
	            String q="select * from students";
	             
	            Statement stmt=con.createStatement();
	            ResultSet set=stmt.executeQuery(q);
	            
	            while(set.next()){
	                int id=set.getInt(1);
	                String name=set.getString(2);
	                String phone=set.getString(3);
	                String city=set.getString(4);
	                System.out.println("Id : "+id+" Name :"+name+" Phone : "+phone+" City :"+city);
	                System.out.println();
	                System.out.println("+++++++++++++++++++++++++++++++++++++++++");
	            }
	            
	            
	               
	        }
	    catch (Exception e){
	        e.printStackTrace();
	    }
		 
		
	}

	public static boolean updateStudentDetails(int userId) {
		boolean f=false;
		 try{	
			 	//jdbc connection
			    Connection con =ConnectionProvider.getConnection();
			    //write update query
			    String q="update students set sname=? ,sphone=?, scity=? where sid=?";
			    
			    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			    
			    System.out.println("Enter New Name :");
			    String name=br.readLine();
			    System.out.println("Enter user phone :");
				String phone=br.readLine();
			    System.out.println("Enter New City name :");
			    String city=br.readLine();
			    

			    
			    PreparedStatement pstmt=con.prepareStatement(q);
			     pstmt.setString(1,name);
			     pstmt.setString(2,phone);
			     pstmt.setString(3,city);
			     pstmt.setInt(4,userId);
			     
			     pstmt.executeUpdate();
			     f=true;
			}catch (Exception e){
			    e.printStackTrace();
			} 
		 return f;
		
	}

	public static boolean updateStudentNameDetail(int userId) {
		boolean f=false;
		 try{	
			 	//jdbc connection
			    Connection con =ConnectionProvider.getConnection();
			    //write update query
			    String q="update students set sname=?  where sid=?";
			    
			    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			    
			    System.out.println("Enter New Name :");
			    String name=br.readLine();
			    
			    PreparedStatement pstmt=con.prepareStatement(q);
			     pstmt.setString(1,name);
			     pstmt.setInt(2,userId);
			     
			     pstmt.executeUpdate();
			     f=true;
			}catch (Exception e){
			    e.printStackTrace();
			}
		return f;
	}

	public static boolean updateStudentPhoneDetails(int userId) {
		boolean f=false;
		 try{	
			 	//jdbc connection
			    Connection con =ConnectionProvider.getConnection();
			    //write update query
			    String q="update students set sphone=? where sid=?";
			    
			    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			    
			   
			    System.out.println("Enter user phone :");
				String phone=br.readLine();
			    
			    PreparedStatement pstmt=con.prepareStatement(q);
	
			     pstmt.setString(1,phone);
			     pstmt.setInt(2,userId);
			     
			     pstmt.executeUpdate();
			     f=true;
			}catch (Exception e){
			    e.printStackTrace();
			}
		return f;
	}

	public static boolean updateStudentCityDetails(int userId) {
		boolean f=false;
		 try{	
			 	//jdbc connection
			    Connection con =ConnectionProvider.getConnection();
			    //write update query
			    String q="update students set scity=? where sid=?";
			    
			    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			    
			  
			    System.out.println("Enter New City name :");
			    String city=br.readLine();
			 
			    PreparedStatement pstmt=con.prepareStatement(q);
			     pstmt.setString(1,city);
			     pstmt.setInt(2,userId);
			     
			     pstmt.executeUpdate();
			     f=true;
			}catch (Exception e){
			    e.printStackTrace();
			}
		return f;
	}
}
