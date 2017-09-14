package com.kite.entity;
@Deprecated
public class QueryWorks {
	private int currentPage = 1;
	private int index;
	private int size = 6;
	// 维护查询限制条件，外键学生编号
	private int s_id;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getIndex() {
		index = (currentPage - 1) * size;
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int sId) {
		s_id = sId;
	}
}
