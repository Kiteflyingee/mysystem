package com.kite.entity;

/**
 * 只做学生的信息的分页查询
 * @author KITE
 *
 */
public class QueryPage {

	private int currentPage = 1;
	private int index;
	@Deprecated
	private int size = 10;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@Deprecated
	public int getIndex() {
		this.index = (this.currentPage - 1) * this.size;
		return index;
	}
	@Deprecated
	public void setIndex(int index) {
		this.index = index;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
