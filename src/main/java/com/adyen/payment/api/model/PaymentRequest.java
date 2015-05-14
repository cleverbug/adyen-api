/*
 * Copyright 2015 Willian Oki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.adyen.payment.api.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
@SuppressWarnings("serial")
public class PaymentRequest implements Serializable {
	private String merchantAccount;
	private Amount amount;
	private Amount additionalAmount;
	private String reference;
	private String shopperIP;
	private String shopperEmail;
	private String shopperReference;
	private String shopperLocale;
	private String telephoneNumber;
	private Name shopperName;
	private int fraudOffset;
	private int mcc;
	private String merchantOrderReference;
	private String selectedBrand;
	private ShopperInteraction shopperInteraction;
	private Card card;
	private Map<String, String> additionalFields = new HashMap<>();
	private BrowserInfo browserInfo;
	private String md;
	private String paResponse;
	private BillingAddress billingAddress;
	private Installments installments;
	private BankAccount bankAccount;
	private String deliveryDate;
	private String deliveryAddress;
	private String shopperStatement;
	private String socialSecurityNumber;
	private String firstName;
	private String lastName;
	private int captureDelayHours;
	private Date dateOfBirth;
	private String deviceFingerprint;
	private ThreeDSecureData mpiData;
	private Recurring recurring;
	private ForexQuote dccQuote;
	private String selectedRecurringDetailReference;
	private String sessionId;

	public PaymentRequest() {
	}

	/**
	 * @return the merchantAccount
	 */
	public String getMerchantAccount() {
		return merchantAccount;
	}

	/**
	 * @param merchantAccount
	 *            the merchantAccount to set
	 */
	public void setMerchantAccount(String merchantAccount) {
		this.merchantAccount = merchantAccount;
	}

	/**
	 * @return the amount
	 */
	public Amount getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the shopperIP
	 */
	public String getShopperIP() {
		return shopperIP;
	}

	/**
	 * @param shopperIP
	 *            the shopperIP to set
	 */
	public void setShopperIP(String shopperIP) {
		this.shopperIP = shopperIP;
	}

	/**
	 * @return the shopperEmail
	 */
	public String getShopperEmail() {
		return shopperEmail;
	}

	/**
	 * @param shopperEmail
	 *            the shopperEmail to set
	 */
	public void setShopperEmail(String shopperEmail) {
		this.shopperEmail = shopperEmail;
	}

	/**
	 * @return the shopperReference
	 */
	public String getShopperReference() {
		return shopperReference;
	}

	/**
	 * @param shopperReference
	 *            the shopperReference to set
	 */
	public void setShopperReference(String shopperReference) {
		this.shopperReference = shopperReference;
	}

	/**
	 * @return the fraudOffset
	 */
	public long getFraudOffset() {
		return fraudOffset;
	}

	/**
	 * @param fraudOffset
	 *            the fraudOffset to set
	 */
	public void setFraudOffset(int fraudOffset) {
		this.fraudOffset = fraudOffset;
	}

	/**
	 * @return the mcc
	 */
	public int getMcc() {
		return mcc;
	}

	/**
	 * @param mcc
	 *            the mcc to set
	 */
	public void setMcc(int mcc) {
		this.mcc = mcc;
	}

	/**
	 * @return the merchantOrderReference
	 */
	public String getMerchantOrderReference() {
		return merchantOrderReference;
	}

	/**
	 * @param merchantOrderReference
	 *            the merchantOrderReference to set
	 */
	public void setMerchantOrderReference(String merchantOrderReference) {
		this.merchantOrderReference = merchantOrderReference;
	}

	/**
	 * @return the selectedBrand
	 */
	public String getSelectedBrand() {
		return selectedBrand;
	}

	/**
	 * @param selectedBrand
	 *            the selectedBrand to set
	 */
	public void setSelectedBrand(String selectedBrand) {
		this.selectedBrand = selectedBrand;
	}

	/**
	 * @return the shopperInteraction
	 */
	public ShopperInteraction getShopperInteraction() {
		return shopperInteraction;
	}

	/**
	 * @param shopperInteraction
	 *            the shopperInteraction to set
	 */
	public void setShopperInteraction(ShopperInteraction shopperInteraction) {
		this.shopperInteraction = shopperInteraction;
	}

	/**
	 * @return the card
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * @param card
	 *            the card to set
	 */
	public void setCard(Card card) {
		this.card = card;
	}

	/**
	 * @return the additionalFields
	 */
	public Map<String, String> getAdditionalFields() {
		return additionalFields;
	}

	/**
	 * @param additionalFields
	 *            the additionalFields to set
	 */
	public void setAdditionalFields(Map<String, String> additionalFields) {
		this.additionalFields = additionalFields;
	}

	/**
	 * @return the browserInfo
	 */
	public BrowserInfo getBrowserInfo() {
		return browserInfo;
	}

	/**
	 * @param browserInfo
	 *            the browserInfo to set
	 */
	public void setBrowserInfo(BrowserInfo browserInfo) {
		this.browserInfo = browserInfo;
	}

	/**
	 * @return the md
	 */
	public String getMd() {
		return md;
	}

	/**
	 * @param md
	 *            the md to set
	 */
	public void setMd(String md) {
		this.md = md;
	}

	/**
	 * @return the paResponse
	 */
	public String getPaResponse() {
		return paResponse;
	}

	/**
	 * @param paResponse
	 *            the paResponse to set
	 */
	public void setPaResponse(String paResponse) {
		this.paResponse = paResponse;
	}

	/**
	 * @return the billingAddress
	 */
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress
	 *            the billingAddress to set
	 */
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * @return the additionalAmount
	 */
	public Amount getAdditionalAmount() {
		return additionalAmount;
	}

	/**
	 * @return the installments
	 */
	public Installments getInstallments() {
		return installments;
	}

	/**
	 * @param installments
	 *            the installments to set
	 */
	public void setInstallments(Installments installments) {
		this.installments = installments;
	}

	/**
	 * @param additionalAmount
	 *            the additionalAmount to set
	 */
	public void setAdditionalAmount(Amount additionalAmount) {
		this.additionalAmount = additionalAmount;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getShopperLocale() {
		return shopperLocale;
	}

	public void setShopperLocale(String shopperLocale) {
		this.shopperLocale = shopperLocale;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public Name getShopperName() {
		return shopperName;
	}

	public void setShopperName(Name shopperName) {
		this.shopperName = shopperName;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getShopperStatement() {
		return shopperStatement;
	}

	public void setShopperStatement(String shopperStatement) {
		this.shopperStatement = shopperStatement;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCaptureDelayHours() {
		return captureDelayHours;
	}

	public void setCaptureDelayHours(int captureDelayHours) {
		this.captureDelayHours = captureDelayHours;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDeviceFingerprint() {
		return deviceFingerprint;
	}

	public void setDeviceFingerprint(String deviceFingerprint) {
		this.deviceFingerprint = deviceFingerprint;
	}

	public ThreeDSecureData getMpiData() {
		return mpiData;
	}

	public void setMpiData(ThreeDSecureData mpiData) {
		this.mpiData = mpiData;
	}

	public Recurring getRecurring() {
		return recurring;
	}

	public void setRecurring(Recurring recurring) {
		this.recurring = recurring;
	}

	public ForexQuote getDccQuote() {
		return dccQuote;
	}

	public void setDccQuote(ForexQuote dccQuote) {
		this.dccQuote = dccQuote;
	}

	public String getSelectedRecurringDetailReference() {
		return selectedRecurringDetailReference;
	}

	public void setSelectedRecurringDetailReference(
			String selectedRecurringDetailReference) {
		this.selectedRecurringDetailReference = selectedRecurringDetailReference;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext()
				&& i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("PaymentRequest [");
		if (merchantAccount != null) {
			builder.append("merchantAccount=");
			builder.append(merchantAccount);
			builder.append(", ");
		}
		if (amount != null) {
			builder.append("amount=");
			builder.append(amount);
			builder.append(", ");
		}
		if (additionalAmount != null) {
			builder.append("additionalAmount=");
			builder.append(additionalAmount);
			builder.append(", ");
		}
		if (reference != null) {
			builder.append("reference=");
			builder.append(reference);
			builder.append(", ");
		}
		if (shopperIP != null) {
			builder.append("shopperIP=");
			builder.append(shopperIP);
			builder.append(", ");
		}
		if (shopperEmail != null) {
			builder.append("shopperEmail=");
			builder.append(shopperEmail);
			builder.append(", ");
		}
		if (shopperReference != null) {
			builder.append("shopperReference=");
			builder.append(shopperReference);
			builder.append(", ");
		}
		if (shopperLocale != null) {
			builder.append("shopperLocale=");
			builder.append(shopperLocale);
			builder.append(", ");
		}
		if (telephoneNumber != null) {
			builder.append("telephoneNumber=");
			builder.append(telephoneNumber);
			builder.append(", ");
		}
		if (shopperName != null) {
			builder.append("shopperName=");
			builder.append(shopperName);
			builder.append(", ");
		}
		builder.append("fraudOffset=");
		builder.append(fraudOffset);
		builder.append(", mcc=");
		builder.append(mcc);
		builder.append(", ");
		if (merchantOrderReference != null) {
			builder.append("merchantOrderReference=");
			builder.append(merchantOrderReference);
			builder.append(", ");
		}
		if (selectedBrand != null) {
			builder.append("selectedBrand=");
			builder.append(selectedBrand);
			builder.append(", ");
		}
		if (shopperInteraction != null) {
			builder.append("shopperInteraction=");
			builder.append(shopperInteraction);
			builder.append(", ");
		}
		if (card != null) {
			builder.append("card=");
			builder.append(card);
			builder.append(", ");
		}
		if (additionalFields != null) {
			builder.append("additionalFields=");
			builder.append(toString(additionalFields.entrySet(), maxLen));
			builder.append(", ");
		}
		if (browserInfo != null) {
			builder.append("browserInfo=");
			builder.append(browserInfo);
			builder.append(", ");
		}
		if (md != null) {
			builder.append("md=");
			builder.append(md);
			builder.append(", ");
		}
		if (paResponse != null) {
			builder.append("paResponse=");
			builder.append(paResponse);
			builder.append(", ");
		}
		if (billingAddress != null) {
			builder.append("billingAddress=");
			builder.append(billingAddress);
			builder.append(", ");
		}
		if (installments != null) {
			builder.append("installments=");
			builder.append(installments);
			builder.append(", ");
		}
		if (bankAccount != null) {
			builder.append("bankAccount=");
			builder.append(bankAccount);
			builder.append(", ");
		}
		if (deliveryDate != null) {
			builder.append("deliveryDate=");
			builder.append(deliveryDate);
			builder.append(", ");
		}
		if (deliveryAddress != null) {
			builder.append("deliveryAddress=");
			builder.append(deliveryAddress);
			builder.append(", ");
		}
		if (shopperStatement != null) {
			builder.append("shopperStatement=");
			builder.append(shopperStatement);
			builder.append(", ");
		}
		if (socialSecurityNumber != null) {
			builder.append("socialSecurityNumber=");
			builder.append(socialSecurityNumber);
			builder.append(", ");
		}
		if (firstName != null) {
			builder.append("firstName=");
			builder.append(firstName);
			builder.append(", ");
		}
		if (lastName != null) {
			builder.append("lastName=");
			builder.append(lastName);
			builder.append(", ");
		}
		builder.append("captureDelayHours=");
		builder.append(captureDelayHours);
		builder.append(", ");
		if (dateOfBirth != null) {
			builder.append("dateOfBirth=");
			builder.append(dateOfBirth);
			builder.append(", ");
		}
		if (deviceFingerprint != null) {
			builder.append("deviceFingerprint=");
			builder.append(deviceFingerprint);
			builder.append(", ");
		}
		if (mpiData != null) {
			builder.append("mpiData=");
			builder.append(mpiData);
			builder.append(", ");
		}
		if (recurring != null) {
			builder.append("recurring=");
			builder.append(recurring);
			builder.append(", ");
		}
		if (dccQuote != null) {
			builder.append("dccQuote=");
			builder.append(dccQuote);
			builder.append(", ");
		}
		if (selectedRecurringDetailReference != null) {
			builder.append("selectedRecurringDetailReference=");
			builder.append(selectedRecurringDetailReference);
			builder.append(", ");
		}
		if (sessionId != null) {
			builder.append("sessionId=");
			builder.append(sessionId);
		}
		builder.append("]");
		return builder.toString();
	}
}
