package com.projectatm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class withdraw {
	public static void withdraw(String ac_no) throws SQLException {
		// TODO Auto-generated method stub
		int bal=0;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kittu","root","Kasyap@mysql");
		Statement state = con.createStatement();
//		ResultSet rs = state.executeQuery("select * from atmdb where acno=\""+ac_no+"\";");
//		while(rs.next()) {
//			bal=rs.getInt(4);
//		}
		data dat = new data();
		bal = dat.data(ac_no);
		Scanner sc =new Scanner(System.in);
		System.out.println("enter amount please for withdraw");
		int amount = sc.nextInt();
		if(amount<bal) {
			System.out.println("take money please");
			PreparedStatement state1 = con.prepareStatement("update atmdb set balence=? where acno=?");//updating balence corrsponding to acno
			state1.setInt(1, (bal-amount));
			state1.setString(2, ac_no);
			state1.executeUpdate();
			balence balen = new balence();
			balen.balence(ac_no);
		}
		else {
			System.out.println("insufficient balence");
		}
		
	}

}
