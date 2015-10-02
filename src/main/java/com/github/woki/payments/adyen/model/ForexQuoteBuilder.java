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
package com.github.woki.payments.adyen.model;

import java.util.Date;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
public final class ForexQuoteBuilder {
    private ForexQuoteBuilder() {
        // builder
    }

    public static IValidTill base(String type, String reference, int basePoints) {
        return new Builder(type, reference, basePoints);
    }

    public interface IValidTill {
        IAccount validTill(Date date);
    }

    public interface IAccount {
        IAmounts account(String account, String accountType);
    }

    public interface IAmounts {
        ISource amounts(Amount base, Amount interbank, Amount buy, Amount sell);
    }

    public interface ISource {
        ISignature source(String source);
    }

    public interface ISignature {
        IBuilder signature(String signature);
    }

    public interface IBuilder {
        ForexQuote build();
    }

    private static final class Builder implements IBuilder, IValidTill, IAccount, IAmounts, ISource, ISignature {
        private ForexQuote quote;

        Builder(String type, String reference, int basePoints) {
            quote = new ForexQuote();
            quote.setType(type);
            quote.setReference(reference);
            quote.setBasePoints(basePoints);
        }

        @Override
        public IAmounts account(String account, String accountType) {
            quote.setAccount(account);
            quote.setAccountType(accountType);
            return this;
        }

        @Override
        public ISource amounts(Amount base, Amount interbank, Amount buy, Amount sell) {
            quote.setBaseAmount(base);
            quote.setInterbank(interbank);
            quote.setBuy(buy);
            quote.setSell(sell);
            return this;
        }

        @Override
        public ForexQuote build() {
            return quote;
        }

        @Override
        public IBuilder signature(String signature) {
            quote.setSignature(signature);
            return this;
        }

        @Override
        public ISignature source(String source) {
            quote.setSource(source);
            return this;
        }

        @Override
        public IAccount validTill(Date date) {
            quote.setValidTill(date);
            return this;
        }
    }
}
