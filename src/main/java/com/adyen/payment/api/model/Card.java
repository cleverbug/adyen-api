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

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
@SuppressWarnings("serial")
public class Card implements Serializable {
   private int expiryMonth;
   private int expiryYear;
   private String holderName;
   private String number;
   private String cvc;
   private String issueNumber;
   private String startMonth;
   private String startYear;
   
   public Card() {
   }

   /**
    * @return the expiryMonth
    */
   public int getExpiryMonth() {
      return expiryMonth;
   }

   /**
    * @param expiryMonth the expiryMonth to set
    */
   public void setExpiryMonth(int expiryMonth) {
      this.expiryMonth = expiryMonth;
   }

   /**
    * @return the expiryYear
    */
   public int getExpiryYear() {
      return expiryYear;
   }

   /**
    * @param expiryYear the expiryYear to set
    */
   public void setExpiryYear(int expiryYear) {
      this.expiryYear = expiryYear;
   }

   /**
    * @return the holderName
    */
   public String getHolderName() {
      return holderName;
   }

   /**
    * @param holderName the holderName to set
    */
   public void setHolderName(String holderName) {
      this.holderName = holderName;
   }

   /**
    * @return the number
    */
   public String getNumber() {
      return number;
   }

   /**
    * @param number the number to set
    */
   public void setNumber(String number) {
      this.number = number;
   }

   /**
    * @return the cvc
    */
   public String getCvc() {
      return cvc;
   }

   /**
    * @param cvc the cvc to set
    */
   public void setCvc(String cvc) {
      this.cvc = cvc;
   }

   /**
    * @return the issueNumber
    */
   public String getIssueNumber() {
      return issueNumber;
   }

   /**
    * @param issueNumber the issueNumber to set
    */
   public void setIssueNumber(String issueNumber) {
      this.issueNumber = issueNumber;
   }

   /**
    * @return the startMonth
    */
   public String getStartMonth() {
      return startMonth;
   }

   /**
    * @param startMonth the startMonth to set
    */
   public void setStartMonth(String startMonth) {
      this.startMonth = startMonth;
   }

   /**
    * @return the startYear
    */
   public String getStartYear() {
      return startYear;
   }

   /**
    * @param startYear the startYear to set
    */
   public void setStartYear(String startYear) {
      this.startYear = startYear;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Card [expiryMonth=");
      builder.append(expiryMonth);
      builder.append(", expiryYear=");
      builder.append(expiryYear);
      builder.append(", ");
      if (holderName != null) {
         builder.append("holderName=");
         builder.append(holderName);
         builder.append(", ");
      }
      if (number != null) {
         builder.append("number=");
         builder.append(number);
         builder.append(", ");
      }
      if (cvc != null) {
         builder.append("cvc=");
         builder.append(cvc);
         builder.append(", ");
      }
      if (issueNumber != null) {
         builder.append("issueNumber=");
         builder.append(issueNumber);
         builder.append(", ");
      }
      if (startMonth != null) {
         builder.append("startMonth=");
         builder.append(startMonth);
         builder.append(", ");
      }
      if (startYear != null) {
         builder.append("startYear=");
         builder.append(startYear);
      }
      builder.append("]");
      return builder.toString();
   }
}
