package com.coinfire.pojo;

public class CSV {

	private String cryptocurrency;
	private String marketCap;
	private String comparisonCurrency;
	private String price;
	private String supply;
	private String volume;
	private String change;
	private String timestamp;
	private String market;

	public CSV(String cryptocurrency, String marketCap,
			String comparisonCurrency, String price, String supply,
			String volume, String change, String timestamp, String market) {
		setCryptocurrency(cryptocurrency);
		setMarketCap(marketCap);
		setComparisonCurrency(comparisonCurrency);
		setPrice(price);
		setSupply(supply);
		setVolume(volume);
		setChange(change);
		setTimestamp(timestamp);
		setMarket(market);
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getCryptocurrency() {
		return cryptocurrency;
	}

	public void setCryptocurrency(String cryptocurrency) {
		this.cryptocurrency = cryptocurrency;
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

	public void setComparisonCurrency(String priceCurrency) {
		this.comparisonCurrency = priceCurrency;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
