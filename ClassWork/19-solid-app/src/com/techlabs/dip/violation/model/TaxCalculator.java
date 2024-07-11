package com.techlabs.dip.violation.model;

public class TaxCalculator {
	private DBLogger dbLogger;

	public TaxCalculator(DBLogger dbLogger) {
		this.dbLogger = dbLogger;
	}

	public void calculateTax(int amount, int rate) {
		int tax = 0;
		try {
			tax = amount / rate;
			System.out.println("Tax : " + tax);
		}

		catch (Exception e) {
			dbLogger.log("Devide by zero");
		}
	}

}
