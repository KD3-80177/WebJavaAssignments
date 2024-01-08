package com.sunbeam.beans;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.UserPojo;

public class SignUpBean {
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String mobile;
	private String bdate;
	private boolean Status;
	public SignUpBean() {
		super();
	}
	
	public SignUpBean(String fname, String lname, String email, String password, String mobile, String bdate) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.bdate = bdate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public boolean getStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	public void addUser() {
		try(UserDaoInterface ud = new UserDao()) {
			UserPojo user = new UserPojo(fname,lname,email,password,mobile,bdate);
			int cnt = ud.signUp(user);
			if(cnt > 0)
				Status=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
