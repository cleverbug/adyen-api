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
package com.okis.payments.adyen.model;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
public final class CardBuilder {
    private CardBuilder() {
        // utility
    }

    public static ICvc number(String number) {
        return new Builder(number);
    }

    public interface ICvc {
        IExpiry cvc(String cvc);
    }

    public interface IExpiry {
        IHolder expiry(int year, int month);
    }

    public interface IHolder {
        IBuilder holder(String holder);
    }

    public interface IBuilder {
        Card build();
    }

    private static final class Builder implements IBuilder, ICvc, IExpiry, IHolder {
        private Card card;

        Builder(String number) {
            card = new Card();
            card.setNumber(number);
        }

        @Override
        public IBuilder holder(String holder) {
            card.setHolderName(holder);
            return this;
        }

        @Override
        public IHolder expiry(int year, int month) {
            card.setExpiryMonth(month);
            card.setExpiryYear(year);
            return this;
        }

        @Override
        public IExpiry cvc(String cvc) {
            card.setCvc(cvc);
            return this;
        }

        @Override
        public Card build() {
            return card;
        }
    }
}