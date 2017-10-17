/*
 * Yell Program Challenge 
 */

package com.zopa.ratecalculation;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import com.zopa.ratecalculation.exception.UsageException;
import com.zopa.ratecalculation.format.Formatter;
import com.zopa.ratecalculation.format.PlainTextFormatter;
import com.zopa.ratecalculation.loader.CSVPayloadLoader;
import com.zopa.ratecalculation.loader.PayloadLoader;
import com.zopa.ratecalculation.model.Lender;
import com.zopa.ratecalculation.utils.CalculationUtils;
import com.zopa.ratecalculation.utils.CurrencyUtil;
import com.zopa.ratecalculation.utils.DisplayUtils;

/**
 * Main Entrypoint of the application.
 */
public class Main {

	/** The logger. */
	private static Logger logger = Logger.getLogger(Main.class.getName());

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String... args) {
		logger.log(Level.INFO, "Starting ZOPA Rate Calculation Program ");

		try {
			processArguments(args);
		} catch (UsageException | IOException e) {
			logger.log(Level.SEVERE, "Program terminated unexpectedly, Exception occured", e);
		}

		logger.log(Level.INFO, "Ending Program ");

	}

	/**
	 * Process arguments.
	 *
	 * @param args
	 *            the args
	 * @throws UsageException
	 *             the usage exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static void processArguments(final String[] args) throws UsageException, IOException {

		if (args.length != 2) {
			DisplayUtils.printUsage();
			throw new UsageException("Invalid usage: Please provide two arguments");
		}

		String csvPath = args[0];
		String loanAmmount = args[1];

		// Loan amount in multiple of 100
		final Pattern pattern = Pattern.compile("^[1-9]+[0-9]*00$");
		if (!pattern.matcher(loanAmmount).matches() || Integer.parseInt(loanAmmount) < CurrencyUtil.LOWER_BOUND
				|| Integer.parseInt(loanAmmount) > CurrencyUtil.UPPER_BOUND) {
			throw new UsageException(String.format("Invalid usage, Please request loan between %d and £%d",
					CurrencyUtil.LOWER_BOUND, CurrencyUtil.UPPER_BOUND));
		}

		PayloadLoader loader = new CSVPayloadLoader();

		// Load CSV Data and transform to POJO's
		List<Lender> lenders = loader.loadPayload(csvPath);
		// Get best offering lender
		Optional<Lender> bestRateLender = CalculationUtils.getBestRate(lenders);


		if (!bestRateLender.isPresent() || bestRateLender.get().getRate() == null
				|| bestRateLender.get().getLender() == null)
			throw new UsageException("It is not possible to provide a quote at that time");

		// Get Plain text formatter
		Formatter formatter = new PlainTextFormatter();

		// Aggregate messages to be pushed to outputstream
		formatter.print(System.out,
				CalculationUtils.getDisplayMessages(bestRateLender.get(), Integer.parseInt(loanAmmount)));

	}

}
