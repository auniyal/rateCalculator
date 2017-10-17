package com.zopa.ratecalculation.format;

import java.io.PrintStream;





/**
 * Abstraction for Formating, Can later be used to support new formatting styles  
 * 
 * The Interface Formatter.
 */
public interface Formatter {

	 /**
 	 * Format.
 	 *
 	 * @param out the out
 	 * @param messages the messages
 	 * @return the string buffer
 	 */
 
	void print(PrintStream out, String[] messages);
	
	

	
}
