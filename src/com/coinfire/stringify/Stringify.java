package com.coinfire.stringify;


public class Stringify {

	public static String truncate(String string, Integer count) {
	
		if (countChar(string) > count) {
			return string.substring(0, count - 3) + "...";
		} else {
			StringBuffer sb = new StringBuffer();
			if ((count % 2) > 0) {
				Integer side = (count - countChar(string) - 1) / 2;
				side = side*2-2;

				for (Integer x = 0; x <= side; ++x) {
					sb.append(" ");
				}
				sb.append(string);
				for (Integer x = 0; x < (side + 1); ++x) {
					sb.append(" ");
				}

			} else {
				Integer side = (count - countChar(string)) / 2;
				side = side*2-2;
				
				for (Integer x = 0; x <side; ++x) {
					sb.append(" ");
				}
				sb.append(string);
				for (Integer x = 0; x < side; ++x) {
					sb.append(" ");
				}
			}
			return sb.toString();
		}
	}

	public static Integer countChar(String string) {
		return string.length();
	}
}
