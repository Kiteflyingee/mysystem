package com.kite.entity;

/**
 * 课程信息实体
 * @author KITE
 *
 */
public class ClazzInfo {
	private Integer id;
	private String name;
	//用来记录课程是否是上线状态，避免删除出现的各种问题：1为上线，0为下线
	private Integer status;
	public Integer getId() {
		return id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
