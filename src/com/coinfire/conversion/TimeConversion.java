package com.coinfire.conversion;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConversion {

	public static String timeCoversion(double doubleTime) {
		Date dateTime = new Date();

		long longTime = (long) doubleTime;
		dateTime = new Date(longTime);

		return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
				.format(dateTime);
	}
}
