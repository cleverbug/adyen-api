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
package com.github.woki.payments.adyen;

import javax.validation.constraints.NotNull;
import java.util.Map;
import com.github.woki.payments.adyen.action.Authorise;
import com.github.woki.payments.adyen.action.Cancel;
import com.github.woki.payments.adyen.action.CancelOrRefund;
import com.github.woki.payments.adyen.action.Capture;
import com.github.woki.payments.adyen.action.Refund;
import com.github.woki.payments.adyen.model.ModificationRequest;
import com.github.woki.payments.adyen.model.ModificationResponse;
import com.github.woki.payments.adyen.model.PaymentRequest;
import com.github.woki.payments.adyen.model.PaymentResponse;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("unused")
public final class Client implements IClient {
    private ClientConfig config;

    private Client() {
        // disable default constructor
    }

    public interface IBuilder {
        IBuilder timeout(long connectionTimeout, long readTimeout);
        IBuilder connectionTimeout(long timeout);
        IBuilder readTimeout(long timeout);
        IBuilder proxyUser(String user);
        Client build();
    }

    public static IAccount services(Map<APService, String> services) {
        return new Builder(services);
    }

    public interface IAccount {
        IBuilder credentials(String username, String password);
        IBuilder credentials(String username, String password, String proxyUser);
    }

    private final static class Builder implements IAccount, IBuilder {
        private Client instance = new Client();

        private Builder() {
            // disable default constructor
        }

        Builder(Map<APService, String> services) {
            instance.config = new ClientConfig();
            instance.config.setServices(services);
        }

        @Override
        public IBuilder timeout(long connectionTimeout, long readTimeout) {
            instance.config.setConnectionTimeout((int) connectionTimeout);
            instance.config.setSocketTimeout((int) readTimeout);
            return this;
        }

        @Override
        public IBuilder connectionTimeout(long timeout) {
            instance.config.setConnectionTimeout((int) timeout);
            return this;
        }

        @Override
        public IBuilder readTimeout(long timeout) {
            instance.config.setSocketTimeout((int) timeout);
            return this;
        }

        @Override
        public Client build() {
            return instance;
        }

        @Override
        public IBuilder credentials(String username, String password) {
            return credentials(username, password, null);
        }

        @Override
        public IBuilder credentials(String username, String password, String proxyUser) {
            instance.config.setUsername(username);
            instance.config.setPassword(password);
            instance.config.setProxyUser(proxyUser);
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
