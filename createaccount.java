package com.projectatm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class createaccount {
	public static void create() throws SQLException {
		Scanner sc = new Scanner(System.in);
		//int ch=0;
		//while(ch!=1) {
//		System.out.println("enter your ne acc no: ");
//		String ac_no=sc.next();
		System.out.println("enter your name: ");
		String namec=sc.nextLine();
		System.out.println("please set pin: ");
		int pinc = sc.nextInt();
		System.out.println("enter your initial deposite: ");
		int balencec = sc.nextInt();
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/kittu","root","Kasyap@mysql");
		String ac_no = "ab10020000";
		PreparedStatement stateb = con.prepareStatement("select name from atmdb where acno=?;");
		stateb.setString(1,ac_no);
		ResultSet rs = stateb.executeQuery();
		while(rs.next()) {
			ac_no=rs.getString("name");
		}
		PreparedStatement state = con.prepareStatement("insert into atmdb values(?,?,?,?);");
		state.setString(1, "ab100200"+ac_no);
		state.setString(2, namec);
		state.setInt(3, pinc);
		state.setInt(4, balencec);
		state.executeUpdate();
		System.out.println("account created successfully");
		Statement state1= con.createStatement();
		String acc = "ab100200"+ac_no;
		ResultSet rs1 = state1.executeQuery("select * from atmdb where acno=\""+acc+"\";");
		while(rs1.next()) {
			System.out.println("your account number is "+rs1.getString("acno"));
			System.out.println("details are \n name: "+rs1.getString("name")+"\n balenece: "+rs1.getInt("balence")+"\n account no: "+rs1.getString("acno"));
		}
		PreparedStatement ps3 = con.prepareStatement("update atmdb set name=? where acno=\"ab10020000\";");
		int ram = Integer.parseInt(ac_no);
		ram++;
		ac_no=Integer.toString(ram);
		//ac_no="ab100200"+ac_no;
		ps3.setString(1, ac_no);
		ps3.executeUpdate();
//		int no = Integer.parseInt(ram);
//		no++;
//		ram = Integer.toString(no);
	//System.out.println("enter 1 to close any didit to create anther on!!!");
	//	ch = sc.nextInt();
	//}
	}
	

}
