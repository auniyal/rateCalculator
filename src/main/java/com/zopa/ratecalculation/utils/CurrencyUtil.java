package com.zopa.ratecalculation.utils;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;



/**
 * The Class CurrencyUtil provides helpful methods for Currency.
 */
public class CurrencyUtil {
	
	/**
	 * Instantiates a new currency util.
	 */
	private CurrencyUtil (){}

	/**  LOWER_BOUND for Loan. */
	public static final int LOWER_BOUND = 1000;

	/**   UPPER_BOUND for Loan. */
	public static final int UPPER_BOUND = 15000;
	/** The locale. */
	// Default GBP
	static Locale locale = Locale.UK;

	/**
	 * Format currency.
	 *
	 * @param monthRepayment the price in pence
	 * @return the string
	 */
	public static String formatCurrency(double monthRepayment) {
		if (monthRepayment < 0)
			throw new IllegalStateException("Invalid curreny ammount");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		Currency curr = Currency.getInstance(locale);
		return String.format("%s %s", curr.getSymbol(), currencyFormatter.format( Double.valueOf(monthRepayment)));

	}

}
