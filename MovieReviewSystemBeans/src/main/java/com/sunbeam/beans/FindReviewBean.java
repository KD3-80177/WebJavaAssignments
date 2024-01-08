package com.sunbeam.beans;

import com.sunbeam.dao.ReviewsDao;
import com.sunbeam.dao.ReviewsDaoInterface;
import com.sunbeam.pojo.ReviewPojo;

public class FindReviewBean {
	private int rev_id;
	private ReviewPojo review;
	public FindReviewBean() {
		this.review = null;
	}
	public int getRev_id() {
		return rev_id;
	}
	public void setRev_id(int rev_id) {
		this.rev_id = rev_id;
	}
	public ReviewPojo getReview() {
		return review;
	}
	public void setReview(ReviewPojo review) {
		this.review = review;
	}
	public void FindEditReview() {
		try(ReviewsDaoInterface rd = new ReviewsDao()) {
			this.review = rd.showMyReviews(rev_id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}
