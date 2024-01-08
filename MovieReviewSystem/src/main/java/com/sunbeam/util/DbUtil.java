package com.sunbeam.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/movie";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "manager";
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
}
