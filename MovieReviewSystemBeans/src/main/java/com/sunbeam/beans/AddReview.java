package com.sunbeam.beans;

import com.sunbeam.dao.ReviewsDao;
import com.sunbeam.dao.ReviewsDaoInterface;
import com.sunbeam.pojo.ReviewPojo;

public class AddReview {
	private int mid;
	private String mrev;
	private int mrat;
	private int userID;
	public AddReview() {
		super();
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMrev() {
		return mrev;
	}
	public void setMrev(String mrev) {
		this.mrev = mrev;
	}
	public int getMrat() {
		return mrat;
	}
	public void setMrat(int mrat) {
		this.mrat = mrat;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public void AddMyReview() {
		ReviewPojo rev = new ReviewPojo(mid,mrev,mrat,userID);
		try(ReviewsDaoInterface rd = new ReviewsDao()) {
			int cnt = rd.addReview(rev);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
