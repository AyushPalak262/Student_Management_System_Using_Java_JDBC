package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args) throws  IOException {
		
	 System.out.println("Welcome to Student  Management App");
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 while(true) {
		 System.out.println("Press 1 to ADD student");
		 System.out.println("Press 2 to Delete student");
		 System.out.println("Press 3 to display student");
		 System.out.println("press 4 to Update Student details");
		 System.out.println("press 5 to Exit");
		 int c=Integer.parseInt(br.readLine());
		 
		 
		 if(c==1) {
			 //add student
			 System.out.println("Enter user name :");
			 String name=br.readLine();
			 
			 System.out.println("Enter user phone :");
			 String phone=br.readLine();
			 
			 System.out.println("Enter user city :");
			 String city=br.readLine();
			 
			 //create student object to store student
			 
			 
			 Student st=new Student(name,phone,city);
			 boolean answer=StudentDao.insertStudentDB(st);
			 if(answer) {
				 System.out.println("Student is successfully added...");
			 }else {
				 System.out.println("Something went wrong !!!");
			 }
			 System.out.println(st);
			 }else if(c==2) {
			 //delete student
				 System.out.println("Enter student id to delete:");
				 int userId=Integer.parseInt(br.readLine());
				 boolean f=StudentDao.deleteStudent(userId);
				 if(f) {
					 System.out.println("Student record deleted");
				 }
				 else {
					 System.out.println("Something went wrong");
				 }
		 }else if(c==3) {
			 //display
			 StudentDao.showAllStudent();
		 }else if(c==4) {
		
			 System.out.println("Enter student id to update :");
			 int userId=Integer.parseInt(br.readLine());
			 while(true) {
			 System.out.println("What do you want to update:");
			 System.out.println("Press 1 to update student's name");
			 System.out.println("Press 2 to update student's phone");
			 System.out.println("Press 3 to update student's city");
			 System.out.println("Press 4 to update all details");
			 System.out.println("Press 5 to exit ");
			 int d=Integer.parseInt(br.readLine());
			 if(d==1) {
				 boolean f=StudentDao.updateStudentNameDetail(userId);
				 if(f) {
					 System.out.println("Student's name has been updated");
				 }
				 else {
					 System.out.println("Something went wrong");
					 break;
				 }
			 }else if(d==2) {
				 boolean f=StudentDao.updateStudentPhoneDetails(userId);
				 if(f) {
					 System.out.println("Student's phone number has been updated");
				 }
				 else {
					 System.out.println("Something went wrong");
				 }
			 }else  if(d==3) {
				 boolean f=StudentDao.updateStudentCityDetails(userId);
				 if(f) {
					 System.out.println("Student's city has been updated");
				 }
				 else {
					 System.out.println("Something went wrong");
				 }
			 }else if(d==4) {
				 boolean f=StudentDao.updateStudentDetails(userId);
				 if(f) {
					 System.out.println("Student's record has been updated");
				 }
				 else {
					 System.out.println("Something went wrong");
				 }
				 
			 }else if(d==5) {
				 
				 break;
			 }else {
				 System.out.println("You have pressed wrong option,try again...");
			 }
			 System.out.println("Student details has been update do you want update anymore things or do other operations");
		}
			 
		 }else if(c==5) {
			 //exit
			 break;
		 }else {
			 System.out.println("You have pressed the wrong key, try again...");
			 System.out.println();
		 }
		 
		 System.out.println("Thankyou for using my app");
		 System.out.println();
		 System.out.println();
	 }
	}

}
