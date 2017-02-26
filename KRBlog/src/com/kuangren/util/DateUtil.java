package com.kuangren.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	
	private static Date strToDate(String dateStr) throws ParseException {
		String dateFormat = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		return simpleDateFormat.parse(dateStr);
	}
	public static Date getOldDate() throws ParseException {

		String oldDateStr = "1999-09-09";
		
		return strToDate(oldDateStr);
	}
	
	public static Boolean isNewDate(Date date) throws Exception {
		
		String referDateStr = "2006-06-06";
		
		Date referDate = strToDate(referDateStr);
		
		if (date != null) {
			if (referDate.before(date)) {
				return true;
			}
		}
		return false;
	}
}
