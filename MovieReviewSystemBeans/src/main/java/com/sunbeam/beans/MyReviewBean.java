package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.dao.ReviewsDao;
import com.sunbeam.dao.ReviewsDaoInterface;
import com.sunbeam.pojo.ReviewPojo;

public class MyReviewBean {
	private int userId;
	private List<ReviewPojo> myRevList;
	public MyReviewBean() {
		this.myRevList = null;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<ReviewPojo> getMyRevList() {
		return myRevList;
	}
	public void setMyRevList(List<ReviewPojo> myRevList) {
		this.myRevList = myRevList;
	}
	public void fetchMyReview() {
		try(ReviewsDaoInterface rd = new ReviewsDao()) {
			myRevList = rd.showResReviews(userId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
