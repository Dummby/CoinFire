package com.coinfire.markets;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.coinfire.property.PropertyLoader;
import com.coinfire.util.Constants;

public class Markets {

	public static Map<String, Long> getMarketMap() {
		
		PropertyLoader pl = new PropertyLoader();
		Properties prop = pl.getProp();
		
		Map<String, Long> marketMap = new HashMap<String, Long>();
			
		marketMap.put(Constants.coinMarketcapURL, Long.valueOf(prop.getProperty(Constants.cccLimit)));
		marketMap.put(Constants.bitcoinChartsURL, Long.valueOf(prop.getProperty(Constants.bccLimit)));
		marketMap.put(Constants.cryptocoinChartsURL, Long.valueOf(prop.getProperty(Constants.cccLimit)));
		
		return marketMap;
	}
	
}
