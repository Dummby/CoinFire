package com.coinfire.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.coinfire.csv.WriteCSV;
import com.coinfire.main.CoinFire;
import com.coinfire.main.Constants;
import com.coinfire.main.Log;
import com.coinfire.main.OnOff;
import com.coinfire.pojo.JSON;

/*
 * @author Adam InTae Gerard
 */

public class PullData extends Thread {
	long minPrime;

	public PullData(long minPrime) {
		this.minPrime = minPrime;
	}

	public void run() {
		try {
			while (OnOff.onOff.equals(1)) {
				parseResponse(GenerateRequest.getCoinMarketCap());

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

	public static void parseResponse(String input) {
		StringBuffer parsedResponse = new StringBuffer();
		String selectedCurrencyAppendString = "Current Price "
				+ CoinFire.comboBox1.getValue() + ": ";
		String selectedCurrency = CoinFire.comboBox1.getValue().toLowerCase();
		Boolean csvDump = CoinFire.csvDump.isSelected();

		try {
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(input);

			if (CoinFire.btcCheckBox.isSelected()) {
				JSON bitcoin = new JSON(jsonObject, Constants.bitcoin,
						selectedCurrency);
				parsedResponse.append(Constants.bitcoin + ": ");
				parsedResponse.append(
						selectedCurrencyAppendString + bitcoin.getRealPrice())
						.append(Constants.breakLine);
				if (csvDump) {
					WriteCSV.writeCSV(bitcoin);
				}
			}

			if (CoinFire.ethereumCheckBox.isSelected()) {
				JSON ethereum = new JSON(jsonObject, Constants.ethereum,
						selectedCurrency);
				parsedResponse.append(Constants.ethereum + ": ");
				parsedResponse.append(
						selectedCurrencyAppendString + ethereum.getRealPrice())
						.append(Constants.breakLine);
				if (csvDump) {
					WriteCSV.writeCSV(ethereum);
				}
			}
			if (CoinFire.rippleCheckBox.isSelected()) {
				JSON ripple = new JSON(jsonObject, Constants.ripple,
						selectedCurrency);
				parsedResponse.append(Constants.ripple + ": ");
				parsedResponse.append(
						selectedCurrencyAppendString + ripple.getRealPrice())
						.append(Constants.breakLine);
				if (csvDump) {
					WriteCSV.writeCSV(ripple);
				}
			}
			if (CoinFire.ltcCheckBox.isSelected()) {
				JSON litecoin = new JSON(jsonObject, Constants.litecoin,
						selectedCurrency);
				parsedResponse.append(Constants.litecoin + ": ");
				parsedResponse.append(
						selectedCurrencyAppendString + litecoin.getRealPrice())
						.append(Constants.breakLine);
				if (csvDump) {
					WriteCSV.writeCSV(litecoin);
				}
			}
			if (CoinFire.dashCheckox.isSelected()) {
				JSON dash = new JSON(jsonObject, Constants.dash,
						selectedCurrency);
				parsedResponse.append(Constants.dash + ": ");
				parsedResponse.append(
						selectedCurrencyAppendString + dash.getRealPrice())
						.append(Constants.breakLine);
				if (csvDump) {
					WriteCSV.writeCSV(dash);
				}
			}

			if (parsedResponse != null && !parsedResponse.toString().isEmpty()) {
				parsedResponse.append("Time: " + Log.getTime().toString());
			}

			Log.logNoTime(parsedResponse.toString());

		} catch (Exception e) {
			Log.log(Constants.genericError + e);
		}
	}
}
