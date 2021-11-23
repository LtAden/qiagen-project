package com.github.LtAden.qiagenproject.model;

import com.github.LtAden.qiagenproject.utilities.Utilities;

/*
 * Class that contains parsed income value, and resulting earnings after tax. Earnings after tax are calculated as follows: income decreased by 19% of PIT tax minus ZUS rate. EAT is
 *  calculated within object construction with formula (income * (1-pit percentage)) - zus rate. If income is 0 or is negative, it makes no sense to calcuate PIT percentage, so in those 
 *  cases, just ZUS cut is applied. Result is rounded to 2 decimal places using rounding method from Utilities.
 */

public class TaxSubtractor {
	private static final double ZUS_RATE = 1380.18;
	private static final double PIT_PERCENTAGE = 0.19;
	private double income;
	private double earningsAfterTaxes;
	
	
	public TaxSubtractor(double income) {
		this.income = income;
		if(income >= 0) {
			this.earningsAfterTaxes = Utilities.round((income*(1-PIT_PERCENTAGE)) - ZUS_RATE, 2);
		} else {
			this.earningsAfterTaxes = Utilities.round(income - ZUS_RATE, 2);
		}
		
	}
	
	public double getIncome() {
		return this.income;
	}
	
	public double getEAT() {
		return this.earningsAfterTaxes;
	}
	
}
