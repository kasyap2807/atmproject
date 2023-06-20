package com.projectatm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class data {
	public static int data(String ac_no) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kittu","root","Kasyap@mysql");
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery("select * from atmdb where acno=\""+ac_no+"\";");//getting all data corresponding to acno
		int bal=0;
		while(rs.next()) {
			bal=rs.getInt(4);//getting and assign only balence having colno 4;
		}
		return bal;//for only balence
	}
}


