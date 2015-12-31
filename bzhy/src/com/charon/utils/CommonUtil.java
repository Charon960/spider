package com.charon.utils;

import org.apache.commons.lang.StringUtils;

/**
 * <p> @author CF
 * <p> 2015年7月9日 下午3:45:13
 * <p> 简单的工具方法
 */
public class CommonUtil {
	
	/**
	 * <p> @author CF
	 * <p> 2015年7月9日 下午3:45:10
	 * <p> 空值替换
	 * @param val
	 * @param defaultVal
	 * @return
	 */
	public static <T>T nvl (T val, T defaultVal) {
		if (val instanceof String && StringUtils.isEmpty((String)val))
			val = null;
		return val == null ? defaultVal : val;
	}

}
