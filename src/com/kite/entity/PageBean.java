package com.kite.entity;

import java.util.List;
@SuppressWarnings("all")
public class PageBean {
	private int currentPage=1;
	@Deprecated
	private int previousPage;
	@Deprecated
	private int nextPage;
	@Deprecated
	private int totalPage;
	private int pageSize;
	private int totalNum;
	private List results;
	@Deprecated
	private int[] pageBar;

	public List getResults() {
		return results;
	}

	public void setResults(List results) {
		this.results = results;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Deprecated
	public int getPreviousPage() {
		previousPage = currentPage - 1;
		if (previousPage < 1) {
			this.previousPage = 1;
		}
		return this.previousPage;
	}
	@Deprecated
	public int getNextPage() {
		nextPage = currentPage + 1;
		if (nextPage > getTotalPage()) {
			nextPage = totalPage;
		}
		return nextPage;
	}
	@Deprecated
	public int getTotalPage() {
		int num = totalNum / pageSize;
		totalPage = (totalNum % pageSize == 0) ? num : num + 1;
		return totalPage;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalNum() {
		return totalNum;
	}
	@Deprecated
	public int[] getPageBar() {
		int start;
		int end;

		if (getTotalPage() <= 5) {
			start = 1;
			end = totalPage;
		} else {
			if (currentPage + 2 > totalPage) {
				end = totalPage;
				start = end - 4;
			} else if (currentPage - 2 < 1) {
				start = 1;
				end = start + 5;
			} else {
				start = currentPage - 2;
				end = currentPage + 2;
			}
		}
		pageBar = new int[end - start + 1];
		for (int i = 0; i < pageBar.length; i++) {
			pageBar[i] = start + i;
		}
		return pageBar;
	}
}
