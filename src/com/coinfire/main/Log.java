package com.coinfire.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @author Adam InTae Gerard
 */

public class Log {

	static String logPath = "";

	public static void log(String message) {
		try {
			BufferedWriter bwr = new BufferedWriter(new FileWriter(
					getLogPath(), true));
			StringBuffer sb = new StringBuffer();
			sb.append(message + " @ " + getTime()).append(
					System.getProperty("line.separator"));
			System.out.println(sb.toString());
			(CoinFire.display).setText(message);
			bwr.write(sb.toString());
			bwr.flush();
			bwr.close();

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static String getTime() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		return df.format(dateobj);
	}

	public static String getLogPath() {
		try {
			if (CoinFire.logFile != null) {
				logPath = CoinFire.logFile.getAbsolutePath();
			} else {
				System.out.println("Log File Not Selected");
			}

		} catch (Exception e) {
			System.out.println("Error Specifying Log File Path " + e);
		}
		return logPath;
	}

	public static void logNoTime(String message) {
		try {
			if (CoinFire.logFile != null) {

				BufferedWriter bwr = new BufferedWriter(new FileWriter(
						getLogPath(), true));
				StringBuffer sb = new StringBuffer();
				sb.append(message).append(System.getProperty("line.separator"));
				System.out.println(sb.toString());
				(CoinFire.display).setText(message);
				bwr.write(sb.toString());
				bwr.flush();
				bwr.close();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
