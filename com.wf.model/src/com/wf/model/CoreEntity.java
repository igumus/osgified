package com.wf.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "CORE_ENTITY")
public class CoreEntity implements IEntity {

	private Long id;
	private CoreEntityType type;	

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TYPE_ID")
	public CoreEntityType getType() {
		return type;
	}

	public void setType(CoreEntityType type) {
		this.type = type;
	}


	@Override
	@Transient
	public void setStatus(Boolean aStatus) {
		
	}

	@Override
	@Transient
	public Boolean getStatus() {
		return Boolean.TRUE;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append(this.getClass().getSimpleName());
		buffer.append(", id:" + this.getId());
		buffer.append(", entityType:[" + this.getType().toString() + "]");
		buffer.append(", status:" + this.getStatus());
		buffer.append("}");
		return buffer.toString();
	}
}
