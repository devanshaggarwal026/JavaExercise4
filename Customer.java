package com.robomq.jdbcAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Customer {
	
	Connection conn ;
	ResultSet res;
	PreparedStatement pre;
	Statement stat;
	int customer_id ;
	String customer_fname , customer_lname , address;
	static Scanner sc = new Scanner(System.in);
	
	
	public Customer() {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb" ,"devansh","Devansh@123" );
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
	
	
	public void addDetails() {
		
		System.out.println("Enter the Customer id");
		customer_id=sc.nextInt();
		System.out.println("Enter the Customer First Name");
		customer_fname=sc.next();
		System.out.println("Enter the Customer Last Name");
		customer_lname=sc.next();
		System.out.println("Enter the Customer Address");
		address=sc.next();
		
		
		try {
			pre = conn.prepareStatement("insert into customer values(?,?,?,?)");
			
			pre.setInt(1, customer_id);
			pre.setString(2, customer_fname);
			pre.setString(3, customer_lname);
			pre.setString(4, address);
			
			int re=pre.executeUpdate();
			
			if(re>0) {
				System.out.println("Customer Details are Added SUCCESSFULLY---");
			}
			else {
				System.out.println("Customer Details Not Addedd---");
			}
			
			pre.close();

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void updateDetails() {
		
		try
		
		{	
			System.out.println("Enter name to update the name\n");
			
			String name=sc.next();
			System.out.println("Enter the customer id for which the name to be updated\n");
			
			int id=sc.nextInt();
			
			pre=conn.prepareStatement("update Customer set Customer_fname=? where Customer_id=?");
			pre.setString(1, name);
			pre.setInt(2,id );
			int re=pre.executeUpdate();
			if(re>0) {
				System.out.println("Name updated for customerid");
			}
			else {
				System.out.println("Name is not updated..");
			}
			pre.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	public void deleteDetails() {
		
		try {
			
			System.out.println("Enter the customer_id to delete the record");
			int customer_id=sc.nextInt();
			pre=conn.prepareStatement("delete from Customer where Customer_id=?");
			pre.setInt(1,customer_id);
			int re=pre.executeUpdate();
			if(re>0) {
				System.out.println("Record deleted");
				
			}
			else {
				System.out.println("Record not deleted");		
				}
			pre.close();
			}
	
		
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	

	
	public void printDetails() {
		
		try {
			stat=conn.createStatement();
			res=stat.executeQuery("select * from Customer");
			
			while(res.next()) {
				System.out.println("Customer_id: "+res.getInt("Customer_id"));
				
				System.out.println("Customer_fname: "+res.getString("Customer_fname"));
				System.out.println("Customer_lname: "+res.getString("Customer_lname"));
				System.out.println("Customer_address: "+res.getString("Customer_address"));
				System.out.println("Customer_email: "+res.getString("Customer_email"));
				
				System.out.println("");

			}
			
		}	
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}	
	