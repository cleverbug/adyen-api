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
public class PaymentResponse extends Error implements Serializable {
   private String pspReference;
   private ResultCode resultCode;
   private String authCode;
   private String refusalReason;
   private Map<String, String> additionalData = new HashMap<String, String>();
   private String paRequest;
   private String md;
   
   
   public PaymentResponse() {
   }

   /**
    * @return the pspReference
    */
   public String getPspReference() {
      return pspReference;
   }

   /**
    * @param pspReference the pspReference to set
    */
   public void setPspReference(String pspReference) {
      this.pspReference = pspReference;
   }

   /**
    * @return the resultCode
    */
   public ResultCode getResultCode() {
      return resultCode;
   }

   /**
    * @param resultCode the resultCode to set
    */
   public void setResultCode(ResultCode resultCode) {
      this.resultCode = resultCode;
   }

   /**
    * @return the authCode
    */
   public String getAuthCode() {
      return authCode;
   }

   /**
    * @param authCode the authCode to set
    */
   public void setAuthCode(String authCode) {
      this.authCode = authCode;
   }

   /**
    * @return the refusalReason
    */
   public String getRefusalReason() {
      return refusalReason;
   }

   /**
    * @param refusalReason the refusalReason to set
    */
   public void setRefusalReason(String refusalReason) {
      this.refusalReason = refusalReason;
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
    * @return the paRequest
    */
   public String getPaRequest() {
      return paRequest;
   }

   /**
    * @param paRequest the paRequest to set
    */
   public void setPaRequest(String paRequest) {
      this.paRequest = paRequest;
   }

   /**
    * @return the md
    */
   public String getMd() {
      return md;
   }

   /**
    * @param md the md to set
    */
   public void setMd(String md) {
      this.md = md;
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
      builder.append("PaymentResponse [");
      if (pspReference != null) {
         builder.append("pspReference=");
         builder.append(pspReference);
         builder.append(", ");
      }
      if (resultCode != null) {
         builder.append("resultCode=");
         builder.append(resultCode);
         builder.append(", ");
      }
      if (authCode != null) {
         builder.append("authCode=");
         builder.append(authCode);
         builder.append(", ");
      }
      if (refusalReason != null) {
         builder.append("refusalReason=");
         builder.append(refusalReason);
         builder.append(", ");
      }
      if (additionalData != null) {
         builder.append("additionalData=");
         builder.append(toString(additionalData.entrySet(), maxLen));
         builder.append(", ");
      }
      if (paRequest != null) {
         builder.append("paRequest=");
         builder.append(paRequest);
         builder.append(", ");
      }
      if (md != null) {
         builder.append("md=");
         builder.append(md);
         builder.append(", ");
      }
      builder.append("status=");
      builder.append(status);
      builder.append(", errorCode=");
      builder.append(errorCode);
      builder.append(", ");
      if (message != null) {
         builder.append("message=");
         builder.append(message);
         builder.append(", ");
      }
      if (errorType != null) {
         builder.append("errorType=");
         builder.append(errorType);
      }
      builder.append("]");
      return builder.toString();
   }
}
