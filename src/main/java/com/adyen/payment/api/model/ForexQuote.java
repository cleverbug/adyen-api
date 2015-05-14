package com.adyen.payment.api.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ForexQuote implements Serializable {
	private int basePoints;
	private Date validTill;
	private String account;
	private String accountType;
	private Amount baseAmount;
	private Amount buy;
	private Amount interbank;
	private String reference;
	private Amount sell;
	private String signature;
	private String source;
	private String type;
	
	public ForexQuote() {
	}

	public int getBasePoints() {
		return basePoints;
	}

	public void setBasePoints(int basePoints) {
		this.basePoints = basePoints;
	}

	public Date getValidTill() {
		return validTill;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Amount getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(Amount baseAmount) {
		this.baseAmount = baseAmount;
	}

	public Amount getBuy() {
		return buy;
	}

	public void setBuy(Amount buy) {
		this.buy = buy;
	}

	public Amount getInterbank() {
		return interbank;
	}

	public void setInterbank(Amount interbank) {
		this.interbank = interbank;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Amount getSell() {
		return sell;
	}

	public void setSell(Amount sell) {
		this.sell = sell;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ForexQuote [basePoints=");
		builder.append(basePoints);
		builder.append(", ");
		if (validTill != null) {
			builder.append("validTill=");
			builder.append(validTill);
			builder.append(", ");
		}
		if (account != null) {
			builder.append("account=");
			builder.append(account);
			builder.append(", ");
		}
		if (accountType != null) {
			builder.append("accountType=");
			builder.append(accountType);
			builder.append(", ");
		}
		if (baseAmount != null) {
			builder.append("baseAmount=");
			builder.append(baseAmount);
			builder.append(", ");
		}
		if (buy != null) {
			builder.append("buy=");
			builder.append(buy);
			builder.append(", ");
		}
		if (interbank != null) {
			builder.append("interbank=");
			builder.append(interbank);
			builder.append(", ");
		}
		if (reference != null) {
			builder.append("reference=");
			builder.append(reference);
			builder.append(", ");
		}
		if (sell != null) {
			builder.append("sell=");
			builder.append(sell);
			builder.append(", ");
		}
		if (signature != null) {
			builder.append("signature=");
			builder.append(signature);
			builder.append(", ");
		}
		if (source != null) {
			builder.append("source=");
			builder.append(source);
			builder.append(", ");
		}
		if (type != null) {
			builder.append("type=");
			builder.append(type);
		}
		builder.append("]");
		return builder.toString();
	}
}
