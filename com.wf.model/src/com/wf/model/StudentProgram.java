package com.wf.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_PROGRAM")
public class StudentProgram implements IEntity {
	
	private Long id;
	private Student student;
	private CoreKeyValue program;
	private Boolean status;

	@Id
	@Basic
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "STUDENT_ID")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROGRAM_ID")
	public CoreKeyValue getProgram() {
		return program;
	}

	public void setProgram(CoreKeyValue program) {
		this.program = program;
	}

	@Override
	public void setStatus(Boolean aStatus) {
		this.status = aStatus;
	}

	@Basic
	@Override
	@Column(name = "STATUS")
	public Boolean getStatus() {
		return this.status;
	}
}
