package com.wf.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HRM_PERSON")
public class Person extends CoreEntity {

	private String tcNo;
	private String name;
	private String surname;
	private Boolean status;

	@Basic
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "SURNAME")
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	@Basic
	@Column(name = "STATUS")
	public Boolean getStatus() {
		return this.status;
	}

	@Override
	public void setStatus(Boolean aStatus) {
		this.status = aStatus;
	}

	@Basic
	@Column(name = "TCNO")
	public String getTcNo() {
		return tcNo;
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

}
