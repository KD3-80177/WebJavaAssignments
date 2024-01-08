package com.sunbeam.beans;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.UserPojo;

public class LoginBean {
	private String email;
	private String passwd;
	private UserPojo user;
	public LoginBean() {
		this.user = null;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public UserPojo getUser() {
		return user;
	}
	public void setUser(UserPojo user) {
		this.user = user;
	}
	public void auth() {
		try(UserDaoInterface ud = new UserDao()){
			UserPojo u = ud.findByEmail(email);
			if(u != null && u.getPassword().equals(passwd))
				this.user = u;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
