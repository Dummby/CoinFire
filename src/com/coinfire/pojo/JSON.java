package com.coinfire.pojo;

import org.json.simple.JSONObject;

import com.coinfire.timekeeper.TimeConversion;

public class JSON {

	private String name;
	private String marketCap;
	private String comparisonCurrency;
	private String realPrice;
	private String supply;
	private String volume;
	private String change;
	private String timestamp;
	private String market;

	public JSON(JSONObject jsonObject, String nameRequest, String comparisonCurrency, String market) {
		JSONObject jsonName = (JSONObject) jsonObject.get(nameRequest);
		JSONObject jsonMarketCap = (JSONObject) jsonName.get("market_cap");
		JSONObject jsonPrice = (JSONObject) jsonName.get("price");
		JSONObject jsonVolume = (JSONObject) jsonName.get("volume");
		
		setName(nameRequest);
		setMarketCap((String) jsonMarketCap.get(comparisonCurrency));
		setComparisonCurrency(comparisonCurrency);
		setRealPrice((String) jsonPrice.get(comparisonCurrency));
		setSupply((String) jsonName.get("supply"));
		setVolume((String) jsonVolume.get(comparisonCurrency));
		setChange((String) jsonName.get("change"));
		setTimestamp(TimeConversion.timeCoversion((double) jsonName.get("timestamp")));
		setMarket(market);
	}
	
	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}
	
	public String getComparisonCurrency() {
		return comparisonCurrency;
	}

	public void setComparisonCurrency(String comparisonCurrency) {
		this.comparisonCurrency = comparisonCurrency;
	}

	public String getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(String realPrice) {
		this.realPrice = realPrice;
	}

	public String getSupply() {
		return supply;
	}

	public void setSupply(String supply) {
		this.supply = supply;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getTimestamp() {
		return timestamp.toString();
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}