package com.charon.wrapper;

import java.io.Serializable;

public class ResultEntity implements Serializable{
	
	private static final long serialVersionUID = 2143883435502360341L;
	
	private String name;
	private String birthday;
	private String chinaYear;
	private String minggong;
	private String toutai;
	private String shuyu;
	private ItemEntity[] xunkong;
	private ItemEntity shishen;
	
	public ResultEntity() {
		super();
	}
	public ResultEntity(String name, String birthday, String chinaYear,
			String minggong, String toutai, String shuyu, ItemEntity[] xunkong, ItemEntity shishen) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.chinaYear = chinaYear;
		this.minggong = minggong;
		this.toutai = toutai;
		this.shuyu = shuyu;
		this.xunkong = xunkong;
		this.shishen = shishen;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getChinaYear() {
		return chinaYear;
	}
	public void setChinaYear(String chinaYear) {
		this.chinaYear = chinaYear;
	}
	public String getMinggong() {
		return minggong;
	}
	public void setMinggong(String minggong) {
		this.minggong = minggong;
	}
	public String getToutai() {
		return toutai;
	}
	public void setToutai(String toutai) {
		this.toutai = toutai;
	}
	public String getShuyu() {
		return shuyu;
	}
	public void setShuyu(String shuyu) {
		this.shuyu = shuyu;
	}
	public ItemEntity[] getXunkong() {
		return xunkong;
	}
	public void setXunkong(ItemEntity[] xunkong) {
		this.xunkong = xunkong;
	}
	public ItemEntity getShishen() {
		return shishen;
	}
	public void setShishen(ItemEntity shishen) {
		this.shishen = shishen;
	}
	
}
