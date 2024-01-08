package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.MoviePojo;

public class MoviesDao extends Dao implements MoviesDaoInterface{

	public MoviesDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<MoviePojo> showAllMovie() throws Exception {
		List<MoviePojo> list = new ArrayList<MoviePojo>();
		String sql = "select * from movies";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int m_id = rs.getInt("movie_id");
					String title = rs.getString("title");
					java.sql.Date sqlDate = rs.getDate("release_date");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String rDate = sdf.format(sqlDate);
					MoviePojo m = new MoviePojo(m_id,title,rDate);
					list.add(m);
				}
			}
		}
		return list;
	}

}
