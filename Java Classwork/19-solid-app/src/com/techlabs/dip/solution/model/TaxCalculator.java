package com.techlabs.dip.solution.model;

public class TaxCalculator {
	private ILogger logger;

	public TaxCalculator(ILogger logger) {
		this.logger = logger;
	}

	public void calculateTax(int amount, int rate) {
		int tax = 0;
		try {
			tax = amount / rate;
			System.out.println("Tax : " + tax);
		}

		catch (Exception e) {
			logger.log("Devide by zero");
		}
	}
}
