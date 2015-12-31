package com.charon.wrapper;

import java.io.Serializable;

public class TotalResultEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ResultEntity man;
	private ResultEntity woman;
	private ScoreEntity[] detail;
	private String score;
	public TotalResultEntity() {
		super();
	}
	public TotalResultEntity(ResultEntity man, ResultEntity woman,
			ScoreEntity[] detail, String score) {
		super();
		this.man = man;
		this.woman = woman;
		this.detail = detail;
		this.score = score;
	}
	public ResultEntity getMan() {
		return man;
	}
	public void setMan(ResultEntity man) {
		this.man = man;
	}
	public ResultEntity getWoman() {
		return woman;
	}
	public void setWoman(ResultEntity woman) {
		this.woman = woman;
	}
	public ScoreEntity[] getDetail() {
		return detail;
	}
	public void setDetail(ScoreEntity[] detail) {
		this.detail = detail;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	

}
