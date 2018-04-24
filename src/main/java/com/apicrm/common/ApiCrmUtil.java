package com.apicrm.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiCrmUtil {
	
	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
