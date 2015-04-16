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

import com.neovisionaries.i18n.CountryCode;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
@SuppressWarnings("serial")
public class BillingAddress implements Serializable {
   private String street;
   private String houseNumberOrName;
   private String postalCode;
   private String city;
   private String stateOrProvince;
   private CountryCode country;
   
   public BillingAddress() {
   }

   /**
    * @return the street
    */
   public String getStreet() {
      return street;
   }

   /**
    * @param street the street to set
    */
   public void setStreet(String street) {
      this.street = street;
   }

   /**
    * @return the houseNumberOrName
    */
   public String getHouseNumberOrName() {
      return houseNumberOrName;
   }

   /**
    * @param houseNumberOrName the houseNumberOrName to set
    */
   public void setHouseNumberOrName(String houseNumberOrName) {
      this.houseNumberOrName = houseNumberOrName;
   }

   /**
    * @return the postalCode
    */
   public String getPostalCode() {
      return postalCode;
   }

   /**
    * @param postalCode the postalCode to set
    */
   public void setPostalCode(String postalCode) {
      this.postalCode = postalCode;
   }

   /**
    * @return the city
    */
   public String getCity() {
      return city;
   }

   /**
    * @param city the city to set
    */
   public void setCity(String city) {
      this.city = city;
   }

   /**
    * @return the stateOrProvince
    */
   public String getStateOrProvince() {
      return stateOrProvince;
   }

   /**
    * @param stateOrProvince the stateOrProvince to set
    */
   public void setStateOrProvince(String stateOrProvince) {
      this.stateOrProvince = stateOrProvince;
   }

   /**
    * @return the country
    */
   public CountryCode getCountry() {
      return country;
   }

   /**
    * @param country the country to set
    */
   public void setCountry(CountryCode country) {
      this.country = country;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("BillingAddress [");
      if (street != null) {
         builder.append("street=");
         builder.append(street);
         builder.append(", ");
      }
      if (houseNumberOrName != null) {
         builder.append("houseNumberOrName=");
         builder.append(houseNumberOrName);
         builder.append(", ");
      }
      if (postalCode != null) {
         builder.append("postalCode=");
         builder.append(postalCode);
         builder.append(", ");
      }
      if (city != null) {
         builder.append("city=");
         builder.append(city);
         builder.append(", ");
      }
      if (stateOrProvince != null) {
         builder.append("stateOrProvince=");
         builder.append(stateOrProvince);
         builder.append(", ");
      }
      if (country != null) {
         builder.append("country=");
         builder.append(country);
      }
      builder.append("]");
      return builder.toString();
   }
}
