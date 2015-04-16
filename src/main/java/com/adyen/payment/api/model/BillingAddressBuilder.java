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

import org.apache.commons.lang3.StringUtils;

import com.neovisionaries.i18n.CountryCode;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
public class BillingAddressBuilder {
   private BillingAddressBuilder() {
   }
   
   public static INumber street(String street) {
      return new Builder(street);
   }
   
   public interface INumber {
      IPostalCode numberOrName(String number);
   }
   
   public interface IPostalCode {
      IState city(String city);
   }
   
   public interface IState {
      ICountry state(String state);
   }
   
   public interface ICountry {
      IBuilder country(CountryCode country);
   }
   
   public interface IBuilder {
      BillingAddress build();
   }
   
   private static class Builder implements IBuilder, INumber, IPostalCode, IState, ICountry {
      private BillingAddress address;
      
      Builder(String street) {
         if(StringUtils.isNotBlank(street)) {
            address = new BillingAddress();
            address.setStreet(street);
         } else {
            throw new IllegalArgumentException("blank: street");
         }
      }
      
      /* (non-Javadoc)
       * @see com.adyen.payment.api.model.CardBuilder.IBuilder#build()
       */
      @Override
      public BillingAddress build() {
         return address;
      }

      /* (non-Javadoc)
       * @see com.adyen.payment.api.model.BillingAddressBuilder.ICountry#country(com.neovisionaries.i18n.CountryCode)
       */
      @Override
      public IBuilder country(CountryCode country) {
         if(country != null) {
            address.setCountry(country);
         } else {
            throw new IllegalArgumentException("blank: country");
         }
         return this;
      }

      /* (non-Javadoc)
       * @see com.adyen.payment.api.model.BillingAddressBuilder.IState#state(java.lang.String)
       */
      @Override
      public ICountry state(String state) {
         if(StringUtils.isNotBlank(state)) {
            address.setStateOrProvince(state);
         } else {
            throw new IllegalArgumentException("blank: state");
         }
         return this;
      }

      /* (non-Javadoc)
       * @see com.adyen.payment.api.model.BillingAddressBuilder.IPostalCode#city(java.lang.String)
       */
      @Override
      public IState city(String city) {
         if(StringUtils.isNotBlank(city)) {
            address.setCity(city);
         } else {
            throw new IllegalArgumentException("blank: city");
         }
         return this;
      }

      /* (non-Javadoc)
       * @see com.adyen.payment.api.model.BillingAddressBuilder.INumber#numberOrName(java.lang.String)
       */
      @Override
      public IPostalCode numberOrName(String number) {
         if(StringUtils.isNotBlank(number)) {
            address.setHouseNumberOrName(number);
         } else {
            throw new IllegalArgumentException("blank: number");
         }
         return null;
      }
   }
}
