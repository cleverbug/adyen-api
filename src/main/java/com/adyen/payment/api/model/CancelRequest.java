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
public class CancelRequest implements Serializable {
   private String merchantAccount;
   private String originalReference;
   private String reference;
   
   public CancelRequest() {
   }

   /**
    * @return the merchantAccount
    */
   public String getMerchantAccount() {
      return merchantAccount;
   }

   /**
    * @param merchantAccount the merchantAccount to set
    */
   public void setMerchantAccount(String merchantAccount) {
      this.merchantAccount = merchantAccount;
   }

   /**
    * @return the originalReference
    */
   public String getOriginalReference() {
      return originalReference;
   }

   /**
    * @param originalReference the originalReference to set
    */
   public void setOriginalReference(String originalReference) {
      this.originalReference = originalReference;
   }

   /**
    * @return the reference
    */
   public String getReference() {
      return reference;
   }

   /**
    * @param reference the reference to set
    */
   public void setReference(String reference) {
      this.reference = reference;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("CancelRequest [");
      if (merchantAccount != null) {
         builder.append("merchantAccount=");
         builder.append(merchantAccount);
         builder.append(", ");
      }
      if (originalReference != null) {
         builder.append("originalReference=");
         builder.append(originalReference);
         builder.append(", ");
      }
      if (reference != null) {
         builder.append("reference=");
         builder.append(reference);
      }
      builder.append("]");
      return builder.toString();
   }
}
