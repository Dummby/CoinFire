package com.coinfire.main;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * @author Adam InTae Gerard
 */

public class PullData extends Thread {
	long minPrime;

	PullData(long minPrime) {
		this.minPrime = minPrime;
	}

	public void run() {
		try {
			while (OnOff.onOff.equals(1)) {
				rockOn(CoinFire.btcCheckBox.isSelected(),
						CoinFire.ethereumCheckBox.isSelected(),
						CoinFire.rippleCheckBox.isSelected(),
						CoinFire.ltcCheckBox.isSelected(),
						CoinFire.dashCheckox.isSelected(),
						CoinFire.xmlDump.isSelected());

				if (OnOff.onOff.equals(0)) {
					this.stop();
					break;
				}
				Thread.sleep(250);
			}
		} catch (Exception e) {
			Log.log("Exception encountered: " + e);
		}
	}

	public static void rockOn(boolean btcCheckBoxSelected,
			boolean ethereumCheckBoxSelected, boolean rippleCheckBoxSelected,
			boolean ltcCheckBoxSelected, boolean dashCheckoxSelected, boolean xmlDumpCheckboxSelected) {

		parseResponse(
				GenerateRequest.getCoinMarketCap(), btcCheckBoxSelected,
				ethereumCheckBoxSelected, rippleCheckBoxSelected,
				ltcCheckBoxSelected, dashCheckoxSelected, xmlDumpCheckboxSelected);

	}

	public static void parseResponse(String input,
			boolean btcCheckBoxSelected, boolean ethereumCheckBoxSelected,
			boolean rippleCheckBoxSelected, boolean ltcCheckBoxSelected,
			boolean dashCheckoxSelected, boolean xmlDumpCheckboxSelected) {
		StringBuffer parsedResponse = new StringBuffer();

		try {
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(input);

			if (btcCheckBoxSelected) {
				JSONObject bitcoin = (JSONObject) jsonObject.get("Bitcoin");
				JSONObject price = (JSONObject) bitcoin.get("price");
				String usd = (String) price.get("usd");
				parsedResponse.append("Bitcoin: ");
				parsedResponse.append("Current Price USD: $" + usd).append(
						System.getProperty("line.separator"));
			}

			if (ethereumCheckBoxSelected) {
				JSONObject ethereum = (JSONObject) jsonObject.get("Ethereum");
				JSONObject price = (JSONObject) ethereum.get("price");
				String usd = (String) price.get("usd");
				parsedResponse.append("Ethereum: ");
				parsedResponse.append("Current Price USD: $" + usd).append(
						System.getProperty("line.separator"));
			}
			if (rippleCheckBoxSelected) {
				JSONObject ripple = (JSONObject) jsonObject.get("Ripple");
				JSONObject price = (JSONObject) ripple.get("price");
				String usd = (String) price.get("usd");
				parsedResponse.append("Ripple: ");
				parsedResponse.append("Current Price USD: $" + usd).append(
						System.getProperty("line.separator"));
			}
			if (ltcCheckBoxSelected) {
				JSONObject litecoin = (JSONObject) jsonObject.get("Litecoin");
				JSONObject price = (JSONObject) litecoin.get("price");
				String usd = (String) price.get("usd");
				parsedResponse.append("Litecoin: ");
				parsedResponse.append("Current Price USD: $" + usd).append(
						System.getProperty("line.separator"));
			}
			if (dashCheckoxSelected) {
				JSONObject dash = (JSONObject) jsonObject.get("Dash");
				JSONObject price = (JSONObject) dash.get("price");
				String usd = (String) price.get("usd");
				parsedResponse.append("Dash: ");
				parsedResponse.append("Current Price USD: $" + usd).append(
						System.getProperty("line.separator"));
			}
			
			if (xmlDumpCheckboxSelected) {
				
			}
				
			if (parsedResponse != null && !parsedResponse.toString().isEmpty()) {
				parsedResponse.append("Time: " + Log.getTime().toString());
			}
			
			Log.logNoTime(parsedResponse.toString());

		} catch (Exception e) {
			Log.log("Exception encountered: " + e);
		}
	}
}
