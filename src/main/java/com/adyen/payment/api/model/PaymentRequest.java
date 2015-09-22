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

import static org.boon.Boon.toJson;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial")
public class PaymentRequest implements Serializable {
    private Amount additionalAmount;
    private Map<String, String> additionalData = new HashMap<>();
    private Amount amount;
    private BankAccount bankAccount;
    private BillingAddress billingAddress;
    private BrowserInfo browserInfo;
    private int captureDelayHours;
    private Card card;
    private Date dateOfBirth;
    private ForexQuote dccQuote;
    private String deliveryAddress;
    private String deliveryDate;
    private String deviceFingerprint;
    private int fraudOffset;
    private Installments installments;
    private int mcc;
    private String md;
    private String merchantAccount;
    private String merchantOrderReference;
    private ThreeDSecureData mpiData;
    private String orderReference;
    private String paResponse;
    private Recurring recurring;
    private String reference;
    private String selectedBrand;
    private String selectedRecurringDetailReference;
    private String sessionId;
    private String shopperEmail;
    private String shopperIP;
    private ShopperInteraction shopperInteraction;
    private String shopperLocale;
    private Name shopperName;
    private String shopperReference;
    private String shopperStatement;
    private String socialSecurityNumber;
    private String telephoneNumber;

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getShopperIP() {
        return shopperIP;
    }

    public void setShopperIP(String shopperIP) {
        this.shopperIP = shopperIP;
    }

    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public long getFraudOffset() {
        return fraudOffset;
    }

    public void setFraudOffset(int fraudOffset) {
        this.fraudOffset = fraudOffset;
    }

    public int getMcc() {
        return mcc;
    }

    public void setMcc(int mcc) {
        this.mcc = mcc;
    }

    public String getMerchantOrderReference() {
        return merchantOrderReference;
    }

    public void setMerchantOrderReference(String merchantOrderReference) {
        this.merchantOrderReference = merchantOrderReference;
    }

    public String getSelectedBrand() {
        return selectedBrand;
    }

    public void setSelectedBrand(String selectedBrand) {
        this.selectedBrand = selectedBrand;
    }

    public ShopperInteraction getShopperInteraction() {
        return shopperInteraction;
    }

    public void setShopperInteraction(ShopperInteraction shopperInteraction) {
        this.shopperInteraction = shopperInteraction;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Amount getAdditionalAmount() {
        return additionalAmount;
    }

    public Installments getInstallments() {
        return installments;
    }

    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

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

    public void setSelectedRecurringDetailReference(String selectedRecurringDetailReference) {
        this.selectedRecurringDetailReference = selectedRecurringDetailReference;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getPaResponse() {
        return paResponse;
    }

    public void setPaResponse(String paResponse) {
        this.paResponse = paResponse;
    }

    @Override
    public String toString() {
        return toJson(this);
    }
}
