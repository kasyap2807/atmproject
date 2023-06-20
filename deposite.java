package com.projectatm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deposite {
	public static void deposite(String ac_no) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("enter amount for deposite : ");
		int take = sc.nextInt();
		int bal=0;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kittu","root","Kasyap@mysql");
//		Statement state1 = con.createStatement();
//		ResultSet rs = state1.executeQuery("select * from atmdb where acno=\""+ac_no+"\";");
//		while(rs.next()) {
//			bal=rs.getInt(4);
//		}
		data dat = new data();
		bal= dat.data(ac_no);
		PreparedStatement state = con.prepareStatement("update atmdb set balence=? where acno=?");//update balence corrsponding to acno
		state.setInt(1, (bal+take));
		state.setString(2, ac_no);
		state.executeUpdate();
		System.out.println("deposit successful");
		balence balen = new balence();
		balen.balence(ac_no);
	}
}
