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

import java.io.Serializable;
import java.util.Currency;

import org.boon.json.annotations.JsonInclude;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
@SuppressWarnings("serial")
public class Amount implements Serializable {
   private Currency currency;
   @JsonInclude
   private long value;
   
   public Amount() {
   }
   
   public Amount(Currency currency, long value) {
      this.currency = currency;
      this.value = value;
   }

   /**
    * @return the currency
    */
   public Currency getCurrency() {
      return currency;
   }

   /**
    * @param currency the currency to set
    */
   public void setCurrency(Currency currency) {
      this.currency = currency;
   }

   /**
    * @return the value
    */
   public long getValue() {
      return value;
   }

   /**
    * @param value the value to set
    */
   public void setValue(long value) {
      this.value = value;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Amount [");
      if (currency != null) {
         builder.append("currency=");
         builder.append(currency);
         builder.append(", ");
      }
      builder.append("value=");
      builder.append(value);
      builder.append("]");
      return builder.toString();
   }
}
