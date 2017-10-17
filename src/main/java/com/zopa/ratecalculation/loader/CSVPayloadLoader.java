package com.zopa.ratecalculation.loader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.zopa.ratecalculation.model.Lender;




/**
 * The Class CSVPayloadLoader .
 */
public class CSVPayloadLoader implements PayloadLoader {
	
	/* (non-Javadoc)
	 * @see com.yell.pizaachallenge.loader.PayloadLoader#loadPayload(java.lang.String)
	 */
	public List<Lender> loadPayload( String resourcePath) throws IOException {
		
		
		
		
		CsvToBean<Lender> csvToBean = new CsvToBean<Lender>();

		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("Lender", "lender");
		columnMapping.put("Rate", "rate");
		columnMapping.put("Available", "available");

		HeaderColumnNameTranslateMappingStrategy<Lender> strategy = new HeaderColumnNameTranslateMappingStrategy<Lender>();
		strategy.setType(Lender.class);
		strategy.setColumnMapping(columnMapping);

		List<Lender> list = null;
		CSVReader reader = new CSVReader(new FileReader(resourcePath));
		list = csvToBean.parse(strategy, reader);
				

		return list;
	}
}
