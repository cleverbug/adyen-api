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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
@SuppressWarnings("serial")
public class ModificationRequest implements Serializable {
   private Map<String, String> additionalData = new HashMap<String, String>();
   private String authorisationCode;
   private String merchantAccount;
   private Amount modificationAmount;
   private String originalReference;
   private String reference;
   
   public ModificationRequest() {
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

   /**
    * @return the additionalData
    */
   public Map<String, String> getAdditionalData() {
      return additionalData;
   }

   /**
    * @param additionalData the additionalData to set
    */
   public void setAdditionalData(Map<String, String> additionalData) {
      this.additionalData = additionalData;
   }

   /**
    * @return the authorisationCode
    */
   public String getAuthorisationCode() {
      return authorisationCode;
   }

   /**
    * @param authorisationCode the authorisationCode to set
    */
   public void setAuthorisationCode(String authorisationCode) {
      this.authorisationCode = authorisationCode;
   }

   /**
    * @return the modificationAmount
    */
   public Amount getModificationAmount() {
      return modificationAmount;
   }

   /**
    * @param modificationAmount the modificationAmount to set
    */
   public void setModificationAmount(Amount modificationAmount) {
      this.modificationAmount = modificationAmount;
   }

   private String toString(Collection<?> collection, int maxLen) {
      StringBuilder builder = new StringBuilder();
      builder.append("[");
      int i = 0;
      for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
         if (i > 0)
            builder.append(", ");
         builder.append(iterator.next());
      }
      builder.append("]");
      return builder.toString();
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      final int maxLen = 10;
      StringBuilder builder = new StringBuilder();
      builder.append("ModificationRequest [");
      if (additionalData != null) {
         builder.append("additionalData=");
         builder.append(toString(additionalData.entrySet(), maxLen));
         builder.append(", ");
      }
      if (authorisationCode != null) {
         builder.append("authorisationCode=");
         builder.append(authorisationCode);
         builder.append(", ");
      }
      if (merchantAccount != null) {
         builder.append("merchantAccount=");
         builder.append(merchantAccount);
         builder.append(", ");
      }
      if (modificationAmount != null) {
         builder.append("modificationAmount=");
         builder.append(modificationAmount);
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
