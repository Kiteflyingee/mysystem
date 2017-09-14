package com.kite.entity;


/**
 * 维护学习目标(这个是一个自定义的模块)废弃重新构思。
 * 
 * @author KITE
 * 
 */
@Deprecated
public class LearnGoal {

	/**
	 * 用另一个JavaBean来封装图片
	 */
	private Image images;

	/**
	 * 课次有关信息存储（包括学生信息，课程信息，重要属性）
	 */
	private ClazzRecord clazzrecord;
	/**
	 * 老师评语
	 */
	private String t_comment;

	/**
	 * 维护主键
	 */
	private Integer id;

	public ClazzRecord getClazzrecord() {
		return clazzrecord;
	}

	public void setClazzrecord(ClazzRecord clazzrecord) {
		this.clazzrecord = clazzrecord;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Image getImages() {
		return images;
	}

	public void setImages(Image images) {
		this.images = images;
	}

	public String getT_comment() {
		return t_comment;
	}

	public void setT_comment(String tComment) {
		t_comment = tComment;
	}

}
