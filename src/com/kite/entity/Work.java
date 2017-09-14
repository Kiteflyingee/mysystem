package com.kite.entity;

import java.util.Date;

public class Work {

	private Integer id;
	private String name;
	private Date pubtime;
	private String w_comment;
	private String filename;
	private Student student;
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getId() {
		return id;
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

	public Date getPubtime() {
		return pubtime;
	}

	public void setPubtime(Date pubtime) {
		this.pubtime = pubtime;
	}


	public String getW_comment() {
		return w_comment;
	}

	public void setW_comment(String wComment) {
		w_comment = wComment;
	}

}
