package com.projectatm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class pinchange {
	public static void pinchange(String ac_no,String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your new pin:");
		int pinch = sc.nextInt();
		System.out.println("enter again :");
		int pinch2 = sc.nextInt();
		if(pinch==pinch2) {//double check of two pins
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kittu","root","Kasyap@mysql");
		//Statement state = con.createStatement();
		PreparedStatement state1 = con.prepareStatement("update atmdb set pin=? where acno=?");//update pin corresponding to acno
		state1.setInt(1,pinch);
		state1.setString(2, ac_no);
		state1.executeUpdate();
		System.out.println("pin changed successfully");
		Atm atm = new Atm();
		atm.main(args);//back to login page
		}
		else {
			System.out.println("enter again");
			pinchange(ac_no, args);//two pins not same reenter pin again 
		}
	}
}
