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
import static org.boon.Maps.map;
import java.io.Serializable;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial")
public class PaymentResponse extends Error implements Serializable {
    private Map<String, String> additionalData = new HashMap<String, String>();
    private String authCode;
    private Amount dccAmount;
    private String dccSignature;
    private FraudResult fraudResult;
    private String issuerUrl;
    private String md;
    private String paRequest;
    private String pspReference;
    private String refusalReason;
    private ResultCode resultCode;

    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getRefusalReason() {
        return refusalReason;
    }

    public void setRefusalReason(String refusalReason) {
        this.refusalReason = refusalReason;
    }

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public String getPaRequest() {
        return paRequest;
    }

    public void setPaRequest(String paRequest) {
        this.paRequest = paRequest;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public Amount getDccAmount() {
        return dccAmount;
    }

    public void setDccAmount(Amount dccAmount) {
        this.dccAmount = dccAmount;
    }

    public String getDccSignature() {
        return dccSignature;
    }

    public void setDccSignature(String dccSignature) {
        this.dccSignature = dccSignature;
    }

    public FraudResult getFraudResult() {
        return fraudResult;
    }

    public void setFraudResult(FraudResult fraudResult) {
        this.fraudResult = fraudResult;
    }

    public String getIssuerUrl() {
        return issuerUrl;
    }

    public void setIssuerUrl(String issuerUrl) {
        this.issuerUrl = issuerUrl;
    }

    @Override
    public String toString() {
        return toJson(this);
    }

    public static void main(String[] args) {
        PaymentResponse res = new PaymentResponse();
        res.setAdditionalData(map("test-ad-k1", "test-ad-v1", "test-ad-k2", "test-ad-v2"));
        res.setAuthCode("test-authcode");
        res.setDccAmount(new Amount(Currency.getInstance("USD"), 1000L));
        res.setDccSignature("test-dcc-signature");
        FraudResult fr = new FraudResult();
        fr.setAccountScore("test-fr-score");
        res.setFraudResult(fr);
        res.setIssuerUrl("test-issuer-url");
        res.setMd("test-md");
        res.setPaRequest("test-pa-request");
        res.setPspReference("tst-psp-reference");
        res.setRefusalReason("test-refusal-reason");
        res.setResultCode(ResultCode.Authorised);
        res.setErrorCode(100);
        res.setErrorType("test-error");
        res.setMessage("test-message");
        res.setStatus(101);
        System.out.println(res.toString());
    }
}
