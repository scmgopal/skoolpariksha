package com.prabhat.common;

import java.util.Calendar;

public class CalendarUtil {

	public static Calendar StringToDateForDash(String strDate) throws Exception {
		Calendar dtDate = null;
		try {
			strDate = strDate.trim();
			dtDate = Calendar.getInstance();
			dtDate.clear();
			dtDate.setLenient(false);
			dtDate.set(Integer.valueOf(
					strDate.substring(strDate.lastIndexOf("-") + 1, strDate
							.length())).intValue(), Integer.valueOf(
					strDate.substring(3, 5)).intValue() - 1, Integer.valueOf(
					strDate.substring(0, 2)).intValue(), 0, 0, 0);

		} catch (Exception e) {
			throw new Exception(e);
		}
		return dtDate;
	}
}
