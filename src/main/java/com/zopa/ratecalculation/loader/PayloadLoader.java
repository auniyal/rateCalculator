package com.zopa.ratecalculation.loader;

import java.io.IOException;
import java.util.List;

import com.zopa.ratecalculation.model.Lender;


/**
 * Abstraction for loading JSON based payload
 * The Interface PayloadLoader.
 */
public interface PayloadLoader {
	
	/**
	 * Load payload.
	 *
	 * @param resource the resource
	 * @return the byte[]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public List<Lender> loadPayload( String resource) throws IOException; 
}
