package com.coinfire.markets;

import java.util.Map;

import com.coinfire.util.Constants;

public class Markets {

	public static Map<String, Long> marketMap;

	public static Map<String, Long> getMarketMap(String market) {
		if (market != null) {
			marketMap.put(Constants.coinMarketcapURL,
					Constants.coinMarketcapMilli);
		}

		return marketMap;
	}

}
