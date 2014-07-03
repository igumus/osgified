package com.wf.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CORE_KEYVALUE")
public class CoreKeyValue extends CoreEntity {

	private String key;
	private String value;
	private Boolean status;

	@Basic
	@Column(name="KEY")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Basic
	@Column(name="VALUE")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Basic
	@Column(name = "STATUS")
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append(this.getClass().getSimpleName());
		buffer.append(", id:" + this.getId());
		buffer.append(", key:" + this.getKey());
		buffer.append(", value:" + this.getValue());
		buffer.append(", status:" + this.getStatus());
		buffer.append("}");
		return buffer.toString();
	}

}
