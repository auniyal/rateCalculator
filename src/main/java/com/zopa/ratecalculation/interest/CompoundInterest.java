package com.zopa.ratecalculation.interest;


/**
 * The Class CompoundInterest.
 */
public class CompoundInterest implements Interest {

	/* (non-Javadoc)
	 * @see com.zopa.ratecalculation.interest.Interest#calculate(float, float, int)
	 */
	@Override
	public double calculate(float principal, float rate, int period) {
		 double multiplier = Math.pow(1.0 + rate/100.0, period) - 1.0;
		    return multiplier * principal;
	}

}
