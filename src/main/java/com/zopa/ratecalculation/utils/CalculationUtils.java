package com.zopa.ratecalculation.utils;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.zopa.ratecalculation.interest.CompoundInterest;
import com.zopa.ratecalculation.interest.Interest;
import com.zopa.ratecalculation.model.Lender;

/**
 * The Class OffersUtil contains useful methods.
 */
public class CalculationUtils {

	// 36 months or 3 Years
	private static final int PERIOD = 3;

	private CalculationUtils() {
	}

	/**
	 * Gets the best offers.
	 *
	 * @param offers
	 *            the offers
	 * @return the best offers
	 */
	public static Optional<Lender> getBestRate(List<Lender> offers) {
		return offers.stream().collect(Collectors.minBy(Comparator.comparing(Lender::getRate)));

	}

	/**
	 * Gets the display messages.
	 *
	 * @param bestrATE the bestr ATE
	 * @param loanAmmount the loan ammount
	 * @return the display messages
	 */
	public static String[] getDisplayMessages(Lender bestrATE, int loanAmmount) {
		Interest interest = new CompoundInterest();
		double interst = interest.calculate(loanAmmount, bestrATE.getRate(), PERIOD);

		double totalRepayment = loanAmmount + interst;
		double monthRepayment = totalRepayment / (PERIOD * 12);
		DecimalFormat df = new DecimalFormat("#.00");
		String formattedRate = df.format(bestrATE.getRate());

		return new String[] { String.format("Requested amount:%s", CurrencyUtil.formatCurrency(loanAmmount)),
				String.format("Rate:%s%% ", formattedRate),
				String.format("Monthly repayment:%s ", CurrencyUtil.formatCurrency(monthRepayment)),
				String.format("Total repayment:%s ", CurrencyUtil.formatCurrency(totalRepayment)) };

	}
}
