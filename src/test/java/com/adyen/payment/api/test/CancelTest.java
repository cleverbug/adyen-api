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
package com.adyen.payment.api.test;

import static com.adyen.payment.api.APUtil.TEST_SERVICES;
import static com.adyen.payment.api.APUtil.reference;
import static org.junit.Assert.assertTrue;

import java.util.Currency;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adyen.payment.api.APUtil.ReferenceType;
import com.adyen.payment.api.Client;
import com.adyen.payment.api.model.Amount;
import com.adyen.payment.api.model.CancelRequest;
import com.adyen.payment.api.model.CancelRequestBuilder;
import com.adyen.payment.api.model.CancelResponse;
import com.adyen.payment.api.model.CardBuilder;
import com.adyen.payment.api.model.PaymentRequest;
import com.adyen.payment.api.model.PaymentRequestBuilder;
import com.adyen.payment.api.model.PaymentResponse;
import com.adyen.payment.api.model.ShopperInteraction;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=TestApp.class)
public class CancelTest {
   @Value("${aps.merchant.account}") String merchantAccount;
   @Value("${aps.merchant.username}") String username;
   @Value("${aps.merchant.password}") String password;
   
   Client client;
   
   @Before
   public void setup() {
      client = Client
            .services(TEST_SERVICES)
            .credentials("ws_831543@Company.TestCompany", ">N?Xiw/)zuY#LC-}i-!8R9pmv")
            .build();
   }
   
   @After
   public void tearDown() {
      client = null;
   }
   
   @Test
   public void testCancel() {
      PaymentRequest paymentRequest = PaymentRequestBuilder
            .merchantAccount(merchantAccount)
            .amount(new Amount(Currency.getInstance("EUR"), 1000L))
            .card(CardBuilder.number("4111111111111111").cvc("737").expiry(2016, 6).holder("Johnny Tester Visa").build())
            .reference(reference(ReferenceType.UUID))
            .shopper("willian.oki@gmail.com", "127.0.0.1", "Test/DAPI/Cancel/Willian Oki", ShopperInteraction.Ecommerce)
            .build();
      PaymentResponse paymentResponse = client.authorise(paymentRequest);
      assertTrue(paymentResponse != null);
      System.out.println(paymentResponse);
      CancelRequest cancelRequest = CancelRequestBuilder
            .merchantAccount(merchantAccount)
            .originalReference(paymentResponse.getPspReference())
            .reference(reference(ReferenceType.UUID))
            .build();
      CancelResponse cancelResponse = client.cancel(cancelRequest);
      assertTrue(cancelResponse != null);
      System.out.println(cancelResponse);
   }
}
