package com.zopa.ratecalculation.format;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Concrete implementation of Formatter The Class PlainTextFormatter.
 */
public class PlainTextFormatter implements Formatter {


	/* (non-Javadoc)
	 * @see com.zopa.ratecalculation.format.Formatter#print(java.io.PrintStream, java.lang.String[])
	 */
	@Override
	public void print(PrintStream out, String[] displayMessages) {

		PrintWriter writer = new PrintWriter(out, true);
		

		for (String message : displayMessages) {
			writer.println(message);
		}

	}

	

}
