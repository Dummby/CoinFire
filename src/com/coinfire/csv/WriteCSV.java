package com.coinfire.csv;

import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.coinfire.pojo.CSV;
import com.coinfire.pojo.JSON;
import com.coinfire.util.Constants;
import com.coinfire.util.Log;

public class WriteCSV {

	public static void writeCSV(JSON coinObject) {

		ICsvBeanWriter beanWriter = null;
		String csvFileName = getCSVPath(Log.getLogPath()) + "//" + coinObject.getName()
				+ ".csv";

		CSV csvObject = new CSV(coinObject.getName(),
				coinObject.getMarketCap(), coinObject.getComparisonCurrency(),
				coinObject.getRealPrice(), coinObject.getSupply(),
				coinObject.getVolume(), coinObject.getChange(),
				coinObject.getTimestamp());

		try {
			beanWriter = new CsvBeanWriter(new FileWriter(csvFileName),
					CsvPreference.STANDARD_PREFERENCE);

			final String[] header = new String[] { "cryptocurrency",
					"marketCap", "comparisonCurrency", "price", "supply",
					"volume", "change", "timestamp" };
			final CellProcessor[] processors = CryptocurrencyCellProcessor
					.getCryptocurrencyProcessors();

			beanWriter.writeHeader(header);
			beanWriter.write(csvObject, header, processors);

			if (beanWriter != null) {
				beanWriter.close();
			}
			
		} catch (Exception e) {
			Log.log(Constants.genericError + e);
		}
	}

	public static String getCSVPath(String logPathAsString) {

		Path logPath = Paths.get(logPathAsString);
		int elements = logPath.getNameCount();
		Path logSubPath = logPath.subpath(0, elements - 1);

		return logPath.getRoot() + logSubPath.toString();
	}
}
