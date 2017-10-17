package com.zopa.ratecalculation.utils;


/**
 * The Class Transformer provides general methods for transforming src data.
 */
public class DisplayUtils {

	/**
	 * Instantiates a new display utils.
	 */
	private DisplayUtils(){}
	
	/**
	 * Prints the usage.
	 */
	public static void printUsage() {

		System.out.println();
		System.out.println("ZOOPA RATE CALULATOR.");
		System.out.println("VM arguments provides what CSV to read and the amount requested");
		System.out.println();
		System.out.println("Usage example: market.csv 1500");
		System.out.println();
	}


}
