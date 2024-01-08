package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.ReviewPojo;

public class ReviewsDao extends Dao implements ReviewsDaoInterface{

	public ReviewsDao() throws SQLException {
		
	}

	@Override
	public int addReview(ReviewPojo review) throws Exception {
		int cnt = 0;
		String sql = "insert into reviews values(default, ?,?,?,?,now())";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, review.getM_id());
			stmt.setString(2, review.getReview());
			stmt.setInt(3, review.getRating());
			stmt.setInt(4, review.getUser_id());
			cnt = stmt.executeUpdate();
		}
		return cnt;
	}

	@Override
	public List<ReviewPojo> showAllReviews() throws Exception {
		List<ReviewPojo> list = new ArrayList<ReviewPojo>();
		String sql = "select * from reviews";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int rev_id = rs.getInt("rev_id");
					int mov_id = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int user_id = rs.getInt("user_id");
					Timestamp tobj = rs.getTimestamp("modified");
					String timeStamp = tobj.toString();
					ReviewPojo r = new ReviewPojo(rev_id,mov_id,review,rating,user_id,timeStamp);
					list.add(r);
				}
			}
		}
		return list;
	}

	@Override
	public List<ReviewPojo> showResReviews(int rev_id) throws Exception {
		List<ReviewPojo> list = new ArrayList<ReviewPojo>();
		String sql = "select * from reviews where user_id = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, rev_id);
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int rev_id1 = rs.getInt("rev_id");
					int mov_id = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int user_id = rs.getInt("user_id");
					Timestamp tobj = rs.getTimestamp("modified");
					String timeStamp = tobj.toString();
					ReviewPojo r = new ReviewPojo(rev_id1,mov_id,review,rating,user_id,timeStamp);
					list.add(r);
				}
			}
		}
		return list;
	}

	@Override
	public int updateReview(int rev_id, int rat, String rev) throws Exception {
		int cnt = 0;
		String sql = "update reviews set rating = ? , review = ?, modified = now() where rev_id = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, rat);
			stmt.setString(2, rev);
			stmt.setInt(3, rev_id);
			cnt = stmt.executeUpdate();
		}
		return cnt;
	}

	@Override
	public int deleteReview(int rid) throws Exception {
		int cnt = 0;
		String sql = "delete from reviews where rev_id = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, rid);
			cnt = stmt.executeUpdate();
		}
		return cnt;
	}

	@Override
	public ReviewPojo showMyReviews(int rev_id) throws Exception {
		String sql = "select * from reviews where rev_id = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, rev_id);
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int rev_id1 = rs.getInt("rev_id");
					int mov_id = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int user_id = rs.getInt("user_id");
					Timestamp tobj = rs.getTimestamp("modified");
					String timeStamp = tobj.toString();
					ReviewPojo r = new ReviewPojo(rev_id1,mov_id,review,rating,user_id,timeStamp);
					return r;
				}
			}
		}
		return null;
	}

}
