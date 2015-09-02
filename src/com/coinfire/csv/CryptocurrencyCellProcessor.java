package com.coinfire.csv;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class CryptocurrencyCellProcessor {

	public static CellProcessor[] getCryptocurrencyProcessors() {

		final CellProcessor[] processors = new CellProcessor[] {

		new NotNull(), new NotNull(), new NotNull(), new NotNull(),
				new NotNull(), new NotNull(), new NotNull(), new NotNull() };

		return processors;
	}

}
