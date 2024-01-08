package com.sunbeam.beans;

import com.sunbeam.dao.ReviewsDao;
import com.sunbeam.dao.ReviewsDaoInterface;

public class DeleteReviewBean {
	private int review_id;
	private String message;
	public DeleteReviewBean() {
		super();
	}
	
	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void deleteReview() {
		try(ReviewsDaoInterface rd = new ReviewsDao()) {
			int count = rd.deleteReview(review_id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.message = e.getMessage();
		}
	}
}
