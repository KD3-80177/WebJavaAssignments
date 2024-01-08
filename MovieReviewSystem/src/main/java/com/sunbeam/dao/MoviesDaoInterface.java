package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.pojo.MoviePojo;

public interface MoviesDaoInterface extends AutoCloseable{
	public List<MoviePojo> showAllMovie() throws Exception;
}
