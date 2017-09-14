package com.kite.domain;

/**
 * 新的分页查询实体,按照easyUI数据规范设计
 * 
 * @author KITE
 *
 */
public class QueryInfo {

	/**
	 * 指示要查询的页面,并给初始值1
	 */
	private Integer page = 1;

	/**
	 * 页面大小
	 */
	private Integer rows;

	/**
	 * 计算的起始索引
	 */
	private Integer index;

	public Integer getIndex() {
		index = (page - 1) * rows;
		return index;
	}

	/**
	 * 附加的查询条件
	 */
	private String keyWord;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
}
