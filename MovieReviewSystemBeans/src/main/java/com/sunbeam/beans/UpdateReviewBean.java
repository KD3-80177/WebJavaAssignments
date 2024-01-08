package com.sunbeam.beans;

import com.sunbeam.dao.ReviewsDao;
import com.sunbeam.dao.ReviewsDaoInterface;

public class UpdateReviewBean {
	private int rev_id;
	private int rat;
	private String rev;
	public UpdateReviewBean() {
		super();
	}
	public int getRev_id() {
		return rev_id;
	}
	public void setRev_id(int rev_id) {
		this.rev_id = rev_id;
	}
	public int getRat() {
		return rat;
	}
	public void setRat(int rat) {
		this.rat = rat;
	}
	public String getRev() {
		return rev;
	}
	public void setRev(String rev) {
		this.rev = rev;
	}
	public void UpdateMyReview() {
		try(ReviewsDaoInterface rd = new ReviewsDao()) {
			int cnt = rd.updateReview(rev_id, rat, rev);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
