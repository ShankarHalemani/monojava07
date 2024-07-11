package com.techlabs.dip.solution.test;

import com.techlabs.dip.solution.model.DBLogger;
import com.techlabs.dip.solution.model.FileLogger;
import com.techlabs.dip.solution.model.ILogger;
import com.techlabs.dip.solution.model.TaxCalculator;

public class TaxCalculatorTest {

	public static void main(String[] args) {
		ILogger dbLogger = new DBLogger();
		ILogger fileLogger = new FileLogger();

		TaxCalculator taxCalculator1 = new TaxCalculator(dbLogger);
		taxCalculator1.calculateTax(100, 10);

		TaxCalculator taxCalculator2 = new TaxCalculator(fileLogger);
		taxCalculator2.calculateTax(2000, 0);
	}
}
