package com.coinfire.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * @author Adam InTae Gerard
 */

public class GenerateRequest {

	public static String getCoinMarketCap() {

		StringBuffer result = new StringBuffer();
		try {
			URL obj = new URL(Constants.coinMarketCapGETAll);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				result.append(inputLine);
			}
			in.close();
		} catch (Exception e) {
			Log.log("Exception encountered: " + e);
		}
		return result.toString();
	}
}