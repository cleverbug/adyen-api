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

import com.adyen.payment.api.action.*;
import com.adyen.payment.api.model.ModificationRequest;
import com.adyen.payment.api.model.ModificationResponse;
import com.adyen.payment.api.model.PaymentRequest;
import com.adyen.payment.api.model.PaymentResponse;
import javax.validation.constraints.NotNull;
import java.net.URL;
import java.util.Map;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
public final class Client implements IClient {
    private ClientConfig config;

    private Client() {
        // disable default constructor
    }

    public interface IBuilder {
        IBuilder timeout(long timeout);

        IBuilder connectionTimeout(long timeout);

        IBuilder socketTimeout(long timeout);

        IBuilder proxyUser(String user);

        Client build();
    }

    public static IAccount services(Map<APService, URL> services) {
        return new Builder(services);
    }

    public interface IAccount {
        IBuilder credentials(String username, String password);
    }

    private final static class Builder implements IAccount, IBuilder {
        private Client instance = new Client();

        private Builder() {
            // disable default constructor
        }

        Builder(Map<APService, URL> services) {
            instance.config = new ClientConfig();
            instance.config.setServices(services);
        }

        @Override
        public IBuilder timeout(long timeout) {
            instance.config.setConnectionTimeout((int) timeout);
            instance.config.setSocketTimeout((int) timeout);
            return this;
        }

        @Override
        public IBuilder connectionTimeout(long timeout) {
            instance.config.setConnectionTimeout((int) timeout);
            return this;
        }

        @Override
        public IBuilder socketTimeout(long timeout) {
            instance.config.setSocketTimeout((int) timeout);
            return this;
        }

        @Override
        public Client build() {
            return instance;
        }

        @Override
        public IBuilder credentials(String username, String password) {
            instance.config.setUsername(username);
            instance.config.setPassword(password);
            return this;
        }

        @Override
        public IBuilder proxyUser(String user) {
            instance.config.setProxyUser(user);
            return this;
        }
    }

    @Override
    public PaymentResponse authorise(@NotNull PaymentRequest request) {
        return Authorise.execute(config, request, false);
    }

    @Override
    public PaymentResponse authorise3ds(@NotNull PaymentRequest request) {
        return Authorise.execute(config, request, true);
    }

    @Override
    public PaymentResponse verifyBin(@NotNull PaymentRequest request) {
        return Authorise.execute(config, request, false);
    }

    @Override
    public ModificationResponse capture(@NotNull ModificationRequest request) {
        return Capture.execute(config, request);
    }

    @Override
    public ModificationResponse cancel(@NotNull ModificationRequest request) {
        return Cancel.execute(config, request);
    }

    @Override
    public ModificationResponse refund(@NotNull ModificationRequest request) {
        return Refund.execute(config, request);
    }

    @Override
    public ModificationResponse cancelOrRefund(@NotNull ModificationRequest request) {
        return CancelOrRefund.execute(config, request);
    }
}
