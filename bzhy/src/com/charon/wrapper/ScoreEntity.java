package com.charon.wrapper;

import java.io.Serializable;

public class ScoreEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String desc;
	
	
	public ScoreEntity() {
		super();
	}


	public ScoreEntity(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}

	
}