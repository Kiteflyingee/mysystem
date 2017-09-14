package com.kite.entity;

import java.util.Date;

/**
 * 用来记录学生的课次信息
 * 
 * @author KITE
 * 
 */
public class ClazzRecord {

	private Integer id;
	/**
	 * 报名课时数
	 */
	private Integer classhours;
	/**
	 * 剩下课时数
	 */
	private Integer lasthours;
	/**
	 * 报名时间（第一次）
	 */
	private Date signupdate;
	/**
	 * 报名课程（维护课程外键）
	 */
	private ClazzInfo clazzinfo;
	/**
	 * 维护学生外键
	 */
	private Student student;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClasshours() {
		return classhours;
	}

	public void setClasshours(Integer classhours) {
		this.classhours = classhours;
	}

	public Integer getLasthours() {
		return lasthours;
	}

	public void setLasthours(Integer lasthours) {
		this.lasthours = lasthours;
	}

	public Date getSignupdate() {
		return signupdate;
	}

	public void setSignupdate(Date signupdate) {
		this.signupdate = signupdate;
	}

	public ClazzInfo getClazzinfo() {
		return clazzinfo;
	}

	public void setClazzinfo(ClazzInfo clazzinfo) {
		this.clazzinfo = clazzinfo;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
