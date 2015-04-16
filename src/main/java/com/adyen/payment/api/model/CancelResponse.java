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
public class CancelResponse implements Serializable {
   private String pspReference;
   private String response;
   
   public CancelResponse() {
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
    * @return the response
    */
   public String getResponse() {
      return response;
   }

   /**
    * @param response the response to set
    */
   public void setResponse(String response) {
      this.response = response;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("CancelResponse [");
      if (pspReference != null) {
         builder.append("pspReference=");
         builder.append(pspReference);
         builder.append(", ");
      }
      if (response != null) {
         builder.append("response=");
         builder.append(response);
      }
      builder.append("]");
      return builder.toString();
   }
}
