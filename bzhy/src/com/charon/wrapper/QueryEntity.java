package com.charon.wrapper;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class QueryEntity {
	
	private String user; 
	private String year; 
	private String month; 
	private String day; 
	private String t_ime; 
	private String user_a; 
	private String year_a;
	private String month_a; 
	private String day_a; 
	private String t_ime_a;
	private String type;
	
	
	public Map<String, String> wrap () {
		Map<String, String> map = new HashMap<String, String>();
		Field[] fields = getClass().getDeclaredFields();
		try {
			for (Field field : fields) {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), getClass());
				String value = (String) pd.getReadMethod().invoke(this);
				if (value == null) {
					return null;
				} else {
					map.put(field.getName(), value);
				}
			}
		} catch (Exception e) {
			return null;
		}
		return map;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getT_ime() {
		return t_ime;
	}


	public void setT_ime(String t_ime) {
		this.t_ime = t_ime;
	}


	public String getUser_a() {
		return user_a;
	}


	public void setUser_a(String user_a) {
		this.user_a = user_a;
	}


	public String getYear_a() {
		return year_a;
	}


	public void setYear_a(String year_a) {
		this.year_a = year_a;
	}


	public String getMonth_a() {
		return month_a;
	}


	public void setMonth_a(String month_a) {
		this.month_a = month_a;
	}


	public String getDay_a() {
		return day_a;
	}


	public void setDay_a(String day_a) {
		this.day_a = day_a;
	}


	public String getT_ime_a() {
		return t_ime_a;
	}


	public void setT_ime_a(String t_ime_a) {
		this.t_ime_a = t_ime_a;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public boolean equals(Object paramObject) {
		if (this == paramObject) return true;
		if (paramObject == null || !(paramObject instanceof QueryEntity)) return false;
		QueryEntity _param = (QueryEntity)paramObject;
		if (this.getUser().equals(_param.getUser())
				&& this.getUser_a().equals(_param.getUser_a())
				&& this.getYear().equals(_param.getYear())
				&& this.getYear_a().equals(_param.getYear_a())
				&& this.getMonth().equals(_param.getMonth())
				&& this.getMonth_a().equals(_param.getMonth_a())
				&& this.getDay().equals(_param.getDay())
				&& this.getDay_a().equals(_param.getDay_a())
				&& this.getT_ime().equals(_param.getT_ime())
				&& this.getT_ime_a().equals(_param.getT_ime_a())
				) return true;
		return false;
	}
	
	
	
}
