package com.kite.domain;

import com.kite.entity.QueryResult;

/**
 * 用来集成分页数据（备用），以备以后不用easyUI直接扩展
 * 
 * @author KITE
 *
 */
public class Page<T> {

	/**
	 * 查询信息
	 */
	private QueryInfo queryInfo;
	/**
	 * 查询结果
	 */
	private QueryResult<T> queryResult;

	public QueryInfo getQueryInfo() {
		return queryInfo;
	}

	public void setQueryInfo(QueryInfo queryInfo) {
		this.queryInfo = queryInfo;
	}

	public QueryResult<T> getQueryResult() {
		return queryResult;
	}

	public void setQueryResult(QueryResult<T> queryResult) {
		this.queryResult = queryResult;
	}

}
