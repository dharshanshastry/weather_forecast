package com.org.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final  class DateUtils {

	private DateUtils() {
		
	}
	
	static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	
	public static String formatDate(final Date date) {
		return dateFormat.format(date);
	}
}
