package com.jdbcubuntu;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		try {
			
//			String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";			
			String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
			String user = "hbstudent";
			String pass = "hbstudent";
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
