package com.wf.model;

import java.io.Serializable;

public interface IEntity extends Serializable {

	public void setId(Long id);
	
	public Long getId();
	
	public void setStatus(Boolean aStatus);
	
	public Boolean getStatus();
	
}
