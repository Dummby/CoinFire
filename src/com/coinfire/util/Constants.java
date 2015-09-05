package com.coinfire.util;


/*
 * @Author Adam InTae Gerard
 */

public class Constants {

	public static final String coinMarketcapURL = "http://coinmarketcap-nexuist.rhcloud.com/api/all";
	public static final String cryptocoinChartsURL = "http://api.cryptocoincharts.info/listCoins";
	public static final String bitcoinChartsURL = "http://api.bitcoincharts.com/v1/markets.json";

	public static final String bitcoin = "Bitcoin";
	public static final String ethereum = "Ethereum";
	public static final String ripple = "Ripple";
	public static final String litecoin = "Litecoin";
	public static final String dash = "Dash";
	
	public static final String cccLimit = "cryptocoincharts.min.wait.limit";
	public static final String cmcLimit = "coinmarketcap.min.wait.limit";
	public static final String bccLimit = "bitcoincharts.min.wait.limit";
	
	public static final String setLog = "Set Log File Location";
	public static final String pullData = "Pull Cryptocurrency Data";

	public static final String genericError = "Exception Occured: ";

	public static final String breakLine = System.getProperty("line.separator");
	
	public static final String introString = "Hello, please choose a log file." + breakLine + "Prices displayed are averages." + breakLine + "Specific market data returned in CSV.";
	

}
