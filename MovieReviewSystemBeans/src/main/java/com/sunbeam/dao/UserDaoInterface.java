package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.pojo.UserPojo;

public interface UserDaoInterface extends AutoCloseable{
	List<UserPojo> showAllUser(int id) throws Exception ;
	UserPojo showAllUserRetObj() throws Exception;
	int signUp(UserPojo u) throws Exception;
	List<UserPojo> getUserDetails(int userid) throws Exception;
	UserPojo findByEmail(String email) throws Exception;
	int updateUser(UserPojo u,int userid) throws Exception;
	int updatePassword(int userid,String p) throws Exception;
	
}
