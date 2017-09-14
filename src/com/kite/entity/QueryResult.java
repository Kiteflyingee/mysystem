package com.kite.entity;

import java.util.List;

public class QueryResult <T>{

	private List<T> results;
	private int totalNum;
	

	public QueryResult() {
		super();
	}

	public QueryResult(List<T> results, int totalNum) {
		super();
		this.results = results;
		this.totalNum = totalNum;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

}
