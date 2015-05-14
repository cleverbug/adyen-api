package com.adyen.payment.api.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BankAccount implements Serializable {
	private String bankAccountNumber;
	private String bankLocationId;
	private BankAccountType bankAccountType;
	private String ownerName;
	private String countryCode = "US";
	private String iban;
	private String selectedBrand;
	private String bic;
	
	public BankAccount() {
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankLocationId() {
		return bankLocationId;
	}

	public void setBankLocationId(String bankLocationId) {
		this.bankLocationId = bankLocationId;
	}

	public BankAccountType getBankAccountType() {
		return bankAccountType;
	}

	public void setBankAccountType(BankAccountType bankAccountType) {
		this.bankAccountType = bankAccountType;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getSelectedBrand() {
		return selectedBrand;
	}

	public void setSelectedBrand(String selectedBrand) {
		this.selectedBrand = selectedBrand;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BankAccount [");
		if (bankAccountNumber != null) {
			builder.append("bankAccountNumber=");
			builder.append(bankAccountNumber);
			builder.append(", ");
		}
		if (bankLocationId != null) {
			builder.append("bankLocationId=");
			builder.append(bankLocationId);
			builder.append(", ");
		}
		if (bankAccountType != null) {
			builder.append("bankAccountType=");
			builder.append(bankAccountType);
			builder.append(", ");
		}
		if (ownerName != null) {
			builder.append("ownerName=");
			builder.append(ownerName);
			builder.append(", ");
		}
		if (countryCode != null) {
			builder.append("countryCode=");
			builder.append(countryCode);
			builder.append(", ");
		}
		if (iban != null) {
			builder.append("iban=");
			builder.append(iban);
			builder.append(", ");
		}
		if (selectedBrand != null) {
			builder.append("selectedBrand=");
			builder.append(selectedBrand);
			builder.append(", ");
		}
		if (bic != null) {
			builder.append("bic=");
			builder.append(bic);
		}
		builder.append("]");
		return builder.toString();
	}
}
