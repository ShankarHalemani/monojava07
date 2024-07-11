package com.techlabs.dip.violation.test;

import com.techlabs.dip.violation.model.DBLogger;
import com.techlabs.dip.violation.model.TaxCalculator;

public class TaxCalculatorTest {

	public static void main(String[] args) {
		DBLogger dbLogger = new DBLogger();

		TaxCalculator taxCalculator1 = new TaxCalculator(dbLogger);
		taxCalculator1.calculateTax(100, 10);

		TaxCalculator taxCalculator2 = new TaxCalculator(dbLogger);
		taxCalculator2.calculateTax(2000, 0);

	}

}
