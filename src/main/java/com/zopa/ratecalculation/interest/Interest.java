package com.zopa.ratecalculation.interest;


/**
 * Abstracting Interest, can later be used to derive SI etc etc.
 */
public interface Interest {
	
	/**
	 * Calculate.
	 *
	 * @param principle the principle
	 * @param rate the rate
	 * @param period the period
	 * @return the double
	 */
	public double calculate(float principle, float rate, int period );

}
