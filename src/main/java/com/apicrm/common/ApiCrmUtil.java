package com.apicrm.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

public class ApiCrmUtil {
	
	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean isNullOrEmpty(String val) {
		return val == null || StringUtils.isEmpty(val);
	}

}
