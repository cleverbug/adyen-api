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
package com.adyen.payment.api;

import com.adyen.payment.api.error.APSConfigurationException;
import com.adyen.payment.api.model.CancelOrRefundRequest;
import com.adyen.payment.api.model.CancelOrRefundResponse;
import com.adyen.payment.api.model.CancelRequest;
import com.adyen.payment.api.model.CancelResponse;
import com.adyen.payment.api.model.CaptureRequest;
import com.adyen.payment.api.model.CaptureResponse;
import com.adyen.payment.api.model.PaymentRequest;
import com.adyen.payment.api.model.PaymentResponse;
import com.adyen.payment.api.model.RefundRequest;
import com.adyen.payment.api.model.RefundResponse;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
public interface IClient {
   /**
    * 
    * @param request
    * @return
    * @throws IllegalArgumentException
    * @throws APSConfigurationException
    * @throws APSAccessException
    */
   PaymentResponse authorise(final PaymentRequest request);
   /**
    * 
    * @param request
    * @return
    * @throws IllegalArgumentException
    * @throws APSConfigurationException
    * @throws APSAccessException
    */
   PaymentResponse authorise3ds(final PaymentRequest request);
   /**
    * 
    * @param request
    * @return
    * @throws IllegalArgumentException
    * @throws APSConfigurationException
    * @throws APSAccessException
    */
   PaymentResponse verifyBin(final PaymentRequest request);
   /**
    * 
    * @param request
    * @return
    * @throws IllegalArgumentException
    * @throws APSConfigurationException
    * @throws APSAccessException
    */
   CaptureResponse capture(CaptureRequest request);
   /**
    * 
    * @param request
    * @return
    * @throws IllegalArgumentException
    * @throws APSConfigurationException
    * @throws APSAccessException
    */
   CancelResponse cancel(CancelRequest request);
   /**
    * 
    * @param request
    * @return
    * @throws IllegalArgumentException
    * @throws APSConfigurationException
    * @throws APSAccessException
    */
   RefundResponse refund(RefundRequest request);
   /**
    * 
    * @param request
    * @return
    * @throws IllegalArgumentException
    * @throws APSConfigurationException
    * @throws APSAccessException
    */
   CancelOrRefundResponse cancelOrRefund(CancelOrRefundRequest request);
}
