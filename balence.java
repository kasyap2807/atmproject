package com.projectatm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class balence {
	public static void balence(String ac_no) throws SQLException {
		int bal=0;
		String name = "";
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kittu","root","Kasyap@mysql");
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery("select * from atmdb where acno=\""+ac_no+"\";");//getting all data corrsponding to acno
		while(rs.next()) {
			bal=rs.getInt(4);//getting balence by column no 4
			name=rs.getString(2);//getting name by colno 2
		}
		System.out.println("dear mr/mrs/miss "+name+" your balence is "+bal+" rs. with a/c no. "+ac_no);	
	}
}
