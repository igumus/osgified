package com.wf.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CORE_ENTITY_TYPE")
public class CoreEntityType implements IEntity {
	private Long id;
	private String className;
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

	@Basic
	@Override
	@Column(name = "STATUS")
	public Boolean getStatus() {
		return this.status;
	}

	@Override
	public void setStatus(Boolean aStatus) {
		this.status = aStatus;
	}

	@Basic
	@Column(name = "CLASS_NAME")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append(this.getClass().getSimpleName());
		buffer.append(", id:" + this.getId());
		buffer.append(", className:" + this.getClassName());
		buffer.append(", status:" + this.getStatus());
		buffer.append("}");
		return buffer.toString();
	}
}
