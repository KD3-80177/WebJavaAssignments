package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.sunbeam.DbUtil.DbUtil;

public class Dao implements AutoCloseable{
	protected Connection conn;
	public Dao() throws SQLException {
		conn = DbUtil.getConnection();
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
