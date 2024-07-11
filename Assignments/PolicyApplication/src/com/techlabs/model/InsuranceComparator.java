package com.techlabs.model;

import java.util.Comparator;

public class InsuranceComparator {
	public static class InsuranceByHolderName implements Comparator<InsurancePolicy> {
		@Override
		public int compare(InsurancePolicy insurancePolicy1, InsurancePolicy insurancePolicy2) {

			return insurancePolicy1.getPolicyHolderName().compareTo(insurancePolicy2.getPolicyHolderName());
		}
	}

	public static class InsuranceByAmount implements Comparator<InsurancePolicy> {
		@Override
		public int compare(InsurancePolicy insurancePolicy1, InsurancePolicy insurancePolicy2) {

			return (int) (insurancePolicy1.getPolicyAmount() - insurancePolicy2.getPolicyAmount());
		}
	}

	public static class InsuranceByCreationDate implements Comparator<InsurancePolicy> {
		@Override
		public int compare(InsurancePolicy insurancePolicy1, InsurancePolicy insurancePolicy2) {

			return insurancePolicy1.getPolicyCreationDate().compareTo(insurancePolicy2.getPolicyCreationDate());
		}
	}
}
