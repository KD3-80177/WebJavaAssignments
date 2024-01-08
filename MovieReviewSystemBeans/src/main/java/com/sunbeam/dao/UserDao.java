package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunbeam.pojo.UserPojo;

public class UserDao extends Dao implements UserDaoInterface{
	
	public UserDao()throws Exception {
		
	}
	
	public static Date parseDate(String d) {
		Date dt = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			dt = sdf.parse(d);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dt;
	}
	@Override
	public List<UserPojo> showAllUser(int id) throws Exception {
		List<UserPojo> list = new ArrayList<UserPojo>();
		String sql = "select * from users where id != ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int userId = rs.getInt("id");
					String fname = rs.getString("first_name");
					String lname = rs.getString("last_name");
					String email = rs.getString("email");
					String password = rs.getString("password");
					String mobile = rs.getString("mobile");
					java.sql.Date sDate = rs.getDate("birth");
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String birthDate = sdf.format(sDate);
					UserPojo user = new UserPojo(userId,fname,lname,email,password,mobile,birthDate);
					list.add(user);
				}
			}
		}
		return list;
	}

	@Override
	public UserPojo showAllUserRetObj() throws Exception {
		UserPojo user = new UserPojo();
		String sql = "select * from users";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int userId = rs.getInt("id");
					String fname = rs.getString("first_name");
					String lname = rs.getString("last_name");
					String email = rs.getString("email");
					String password = rs.getString("password");
					String mobile = rs.getString("mobile");
					java.sql.Date sDate = rs.getDate("birth");
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String birthDate = sdf.format(sDate);
					user = new UserPojo(userId,fname,lname,email,password,mobile,birthDate);
				}
			}
		}
		return user;
	}
	@Override
	public int signUp(UserPojo u) throws Exception {
		int cnt = 0;
		String sql = "insert into users values (default,?,?,?,?,?,?)";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, u.getFname());
			stmt.setString(2, u.getLname());
			stmt.setString(3,u.getEmail());
			stmt.setString(4, u.getPassword());
			stmt.setString(5, u.getMobile());
			String bdate = u.getBdate();
			Date utilDate = parseDate(bdate);
			java.sql.Date sqlBDate = new java.sql.Date(utilDate.getTime());
			stmt.setDate(6, sqlBDate);
			cnt = stmt.executeUpdate();
			return cnt;
		}
	}
	@Override
	public List<UserPojo> getUserDetails(int userid) throws Exception {
		List<UserPojo> list = new ArrayList<UserPojo>();
		String sql = "select id,fname,lname,email,mobile,birthDate from users where id = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, userid);
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int userid1 = rs.getInt("id");
					String fname = rs.getString("fname");
					String lname = rs.getString("lname");
					String email1 = rs.getString("email");
					String password = rs.getString("password");
					String mobile = rs.getString("mobile");
					java.sql.Date bd = rs.getDate("birthDate");
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String bdate = sdf.format(bd);
					UserPojo u = new UserPojo(userid1,fname,lname,email1,password,mobile,bdate);
					list.add(u);
				}
			}
		}
		return list;
	}
//	@Override
//	public UserPojo findByEmail(String email) throws Exception {
//		String sql = "select * from users where email=?";
//		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
//			stmt.setString(1, email);
//			try(ResultSet rs = stmt.executeQuery()){
//				if(rs.next()) {
//					int userid1 = rs.getInt("id");
//					String fname = rs.getString("first_name");
//					String lname = rs.getString("last_name");
//					email = rs.getString("email");
//					String password = rs.getString("password");
//					String mobile = rs.getString("mobile");
//					java.sql.Date bd = rs.getDate("birth");
//					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//					String bdate = sdf.format(bd);
//					UserPojo u = new UserPojo(userid1,fname,lname,email,password,mobile,bdate);
//					return u;
//				}
//			}
//		}
//		return null;
//	}
	public UserPojo findByEmail(String email) throws Exception {
		String sql = "SELECT * FROM users WHERE email=?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, email);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String fname = rs.getString("first_name");
					String lname = rs.getString("last_name");
					String password = rs.getString("password");
					email = rs.getString("email");
					String mobile = rs.getString("mobile");
					java.sql.Date bd = rs.getDate("birth");
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String bdate = sdf.format(bd);
					return new UserPojo(id, fname, lname, email, password, mobile, bdate);
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}
	@Override
	public int updateUser(UserPojo u, int userid) throws Exception {
		int cnt = 0;
		String sql = "update users set fname = ?, lname = ?, email = ?, password = ?, mobile = ? , birthDate = ? where id = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, u.getFname());
			stmt.setString(2, u.getLname());
			stmt.setString(3,u.getEmail());
			stmt.setString(4, u.getPassword());
			stmt.setString(5, u.getMobile());
			String bdate = u.getBdate();
			Date utilDate = parseDate(bdate);
			java.sql.Date sqlBDate = new java.sql.Date(utilDate.getTime());
			stmt.setDate(6, sqlBDate);
			stmt.setInt(7, userid);
			cnt = stmt.executeUpdate();
		}
		return cnt;
	}
	@Override
	public int updatePassword(int userid, String p) throws Exception {
		int cnt = 0;
		String sql = "update users set password = ? where id = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, p);
			stmt.setInt(2, userid);
			cnt = stmt.executeUpdate();
		}
		return cnt;
	}

}
