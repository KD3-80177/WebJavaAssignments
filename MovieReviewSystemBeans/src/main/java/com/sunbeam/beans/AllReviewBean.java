package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.dao.ReviewsDao;
import com.sunbeam.dao.ReviewsDaoInterface;
import com.sunbeam.pojo.ReviewPojo;

public class AllReviewBean {
	private List<ReviewPojo> allRevList;

	public AllReviewBean() {
		this.allRevList = null;
	}

	public List<ReviewPojo> getAllRevList() {
		return allRevList;
	}

	public void setAllRevList(List<ReviewPojo> allRevList) {
		this.allRevList = allRevList;
	}
	public void fetchAllRecords() {
		try(ReviewsDaoInterface rd = new ReviewsDao()) {
			allRevList = rd.showAllReviews();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
			// TODO: handle exception
		}
	}
	
}
