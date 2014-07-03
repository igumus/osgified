package com.wf.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student extends Person {

	private String studentNo;

	@Basic
	@Column(name = "STUDENT_NO")
	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	
	@Override
	public String toString() {
		return getId() + " " + this.getClass().getSimpleName();
	}
}
