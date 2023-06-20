package com.projectatm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class tester {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("-------WELCOME-------");
		System.out.println("enter your accout number :");
		String ac_no =sc.nextLine();
		System.out.println("Enter your pin please :");
		int pin = sc.nextInt();
		//strat db
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kittu","root","Kasyap@mysql");
//		PreparedStatement sp = con.prepareStatement("\"select pin from atmdb where acno=?\"");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select pin from atmdb where acno='"+ac_no+"';");
		//sp.setString(1,ac_no);
		int x = 123;
		System.out.print(rs.getInt(3));
		if(x==pin) {
			System.out.println("pin correct");
//			Atm atm = new Atm();
//			atm.menu(ac_no,pin);
		}

	}

}
