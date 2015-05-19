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

import com.adyen.payment.api.error.APSAccessException;
import com.adyen.payment.api.error.APSConfigurationException;
import com.adyen.payment.api.model.ModificationRequest;
import com.adyen.payment.api.model.ModificationResponse;
import com.adyen.payment.api.model.PaymentRequest;
import com.adyen.payment.api.model.PaymentResponse;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
public interface IClient {
    /**
     * @param request
     *
     * @return
     *
     * @throws IllegalArgumentException
     * @throws APSConfigurationException
     * @throws APSAccessException
     */
    PaymentResponse authorise(final PaymentRequest request);

    /**
     * @param request
     *
     * @return
     *
     * @throws IllegalArgumentException
     * @throws APSConfigurationException
     * @throws APSAccessException
     */
    PaymentResponse authorise3ds(final PaymentRequest request);

    /**
     * @param request
     *
     * @return
     *
     * @throws IllegalArgumentException
     * @throws APSConfigurationException
     * @throws APSAccessException
     */
    PaymentResponse verifyBin(final PaymentRequest request);

    /**
     * @param request
     *
     * @return
     *
     * @throws IllegalArgumentException
     * @throws APSConfigurationException
     * @throws APSAccessException
     */
    ModificationResponse capture(ModificationRequest request);

    /**
     * @param request
     *
     * @return
     *
     * @throws IllegalArgumentException
     * @throws APSConfigurationException
     * @throws APSAccessException
     */
    ModificationResponse cancel(ModificationRequest request);

    /**
     * @param request
     *
     * @return
     *
     * @throws IllegalArgumentException
     * @throws APSConfigurationException
     * @throws APSAccessException
     */
    ModificationResponse refund(ModificationRequest request);

    /**
     * @param request
     *
     * @return
     *
     * @throws IllegalArgumentException
     * @throws APSConfigurationException
     * @throws APSAccessException
     */
    ModificationResponse cancelOrRefund(ModificationRequest request);
}
