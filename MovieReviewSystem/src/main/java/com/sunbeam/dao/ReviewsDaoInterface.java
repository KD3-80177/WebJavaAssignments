package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.pojo.ReviewPojo;

public interface ReviewsDaoInterface extends AutoCloseable{
	public int addReview(ReviewPojo review) throws Exception;
	public List<ReviewPojo> showAllReviews() throws Exception;
	public List<ReviewPojo> showResReviews(int rev_id) throws Exception;
	public ReviewPojo showMyReviews(int rev_id) throws Exception;
	public int updateReview(int rev_id,int rat, String rev) throws Exception;
	public int deleteReview(int rid) throws Exception;
}
