package com.robomq.jdbcAssignment;

import java.util.Scanner;

public class CustomerDbms {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		Customer c = new Customer();
		
		c.printDetails();
		System.out.println("enter choiceY/N");
		
		String ch=sc.next();
		
		while(ch.equals("Y")) {
			System.out.println(" Insert 1: To ADD customer details.\nInsert 2: To Edit customer Name based on id.\nInsert 3: To Remove the customer.\nInsert 4: TO Print the Customer Details.\nInsert 5: To exit from the app."
					);
			
			int inp=sc.nextInt();
			if(inp==1) {
				c.addDetails();
			}
			else if(inp==2) {
				c.updateDetails();
			}
			else if(inp==3) {
				c.deleteDetails();
			}
			else if(inp==4) {
				c.printDetails();
			}
			if(inp==5) {
				System.exit(0);
			}

			
			
			System.out.println("Do you want to continueY/N");
			ch=sc.next();
			
			
		}
		
	}	
	

}
