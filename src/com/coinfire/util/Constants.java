package com.coinfire.util;


/*
 * @Author Adam InTae Gerard
 */

public class Constants {

	public static final String coinMarketcapURL = "http://coinmarketcap-nexuist.rhcloud.com/api/all";
	public static final String cryptocoinChartsURL = "http://api.cryptocoincharts.info/listCoins";
	public static final String bitcoinChartsURL = "http://api.bitcoincharts.com/v1/markets.json";

	public static final Long coinMarketcapMilli = Long.valueOf(5 * 60000);
	public static final Long cryptocoinChartsMilli = Long.valueOf(1 * 60000);
	public static final Long bitcoinChartsMilli = Long.valueOf(15 * 60000);
	
	public static final String bitcoin = "Bitcoin";
	public static final String ethereum = "Ethereum";
	public static final String ripple = "Ripple";
	public static final String litecoin = "Litecoin";
	public static final String dash = "Dash";

	public static final String genericError = "Exception Occured: ";

	public static final String breakLine = System.getProperty("line.separator");
	
	public static final String introString = "Hello, please choose a log file." + breakLine + "Prices displayed are averages." + breakLine + "Specific market data returned in CSV.";

}
