package com.charon.wrapper;

import java.io.Serializable;

public class ItemEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String[] values;
	

	public ItemEntity() {
		super();
	}

	public ItemEntity(String name, String[] values) {
		super();
		this.name = name;
		this.values = values;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getValues() {
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}

}
