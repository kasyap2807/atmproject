package com.projectatm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Atm{
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Scanner sc =new Scanner(System.in);
		int ch=0;//set choice to 0;
		System.out.println("-------WELCOME-------");
		System.out.println("enter your accout number :");
		String ac_no = sc.nextLine();
		System.out.println("Enter your pin please :");
		int pin = sc.nextInt();
		int x=0;//if x=0 after getting pin from select query wiich means the acno is wrong and no pin related to that acno;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kittu","root","Kasyap@mysql");
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery("select * from atmdb where acno=\""+ac_no+"\";");
		while(rs.next()) {
			x=rs.getInt(3);//if x== any pin than go to validate pin if pin =0 than wrong acno if pin!=x than wrong pin
		}
		if(pin==x) {
			//Atm atm = new Atm();
			while(true){
			System.out.println("---------select your choice---------- \n 1.balence \n 2.withdraw \n 3.deposite \n 4.pinchange \n 5.exit");
			ch = sc.nextInt();
			switch(ch) {
			case 1:{
				balence balen = new balence();
				balen.balence(ac_no);
				break;
			}
			case 2:{
				withdraw with = new withdraw();
				with.withdraw(ac_no);
				break;
			}
			case 3:{
				deposite dep = new deposite();
				dep.deposite(ac_no);
				break;
			}
			case 4:{
				pinchange pinch = new pinchange();
				pinch.pinchange(ac_no,args);
				break;
			}
			case 5:{
				System.out.println("-------------------thank you-------------------");
				System.exit(0);

				//exit();
			}
			}
		}//while(ch!=5);
	}
		else if(x==0) {
			System.out.println("wrong a/c number for create press 1 for tryagain press 2");
			int ip= sc.nextInt();
			if(ip==2) {
			Atm atm = new Atm();
			atm.main(args);}
			else if(ip==1) {
				createaccount cac =  new createaccount();
				cac.create();
				Atm atm = new Atm();
				atm.main(args);
			}
		}
		else {
			System.out.println("wrong password");
			Atm atm = new Atm();
			atm.main(args);
		}
	}



	

	
	
	
	}
