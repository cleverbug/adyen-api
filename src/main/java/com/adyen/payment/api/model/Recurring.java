package com.adyen.payment.api.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Recurring implements Serializable {
	private ContractType contract;
	private String recurringDetailName;
	
	public Recurring() {
	}
	
	public Recurring(ContractType contract, String recurringDetailName) {
		this.contract = contract;
		this.recurringDetailName = recurringDetailName;
	}

	public ContractType getContract() {
		return contract;
	}

	public void setContract(ContractType contract) {
		this.contract = contract;
	}

	public String getRecurringDetailName() {
		return recurringDetailName;
	}

	public void setRecurringDetailName(String recurringDetailName) {
		this.recurringDetailName = recurringDetailName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recurring [");
		if (contract != null) {
			builder.append("contract=");
			builder.append(contract);
			builder.append(", ");
		}
		if (recurringDetailName != null) {
			builder.append("recurringDetailName=");
			builder.append(recurringDetailName);
		}
		builder.append("]");
		return builder.toString();
	}
}
