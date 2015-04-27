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
package com.adyen.payment.api;

import java.net.URL;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.adyen.payment.api.action.Authorise;
import com.adyen.payment.api.action.Cancel;
import com.adyen.payment.api.action.CancelOrRefund;
import com.adyen.payment.api.action.Capture;
import com.adyen.payment.api.action.Refund;
import com.adyen.payment.api.model.ModificationRequest;
import com.adyen.payment.api.model.ModificationResponse;
import com.adyen.payment.api.model.PaymentRequest;
import com.adyen.payment.api.model.PaymentResponse;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
public class Client implements IClient {
   private ClientConfig config;
   
   private Client() {
   }
   
   public interface IBuilder {
      IBuilder timeout(long timeout);
      IBuilder connectionTimeout(long timeout);
      IBuilder socketTimeout(long timeout);
      
      Client build();
   }
   
   public static IAccount services(Map<APService, URL> services) {
      return new Builder(services);
   }
   
   public interface IAccount {
      IBuilder credentials(String username, String password);
   }
   
   private static class Builder implements IAccount, IBuilder {
      private Client instance = new Client();
      
      Builder(Map<APService, URL> services) {
         if(services != null && services.size() > 0) {
            instance.config = new ClientConfig();
            instance.config.setServices(services);
         } else {
            throw new IllegalArgumentException("blank: services");
         }
      }

      /* (non-Javadoc)
       * @see com.adyen.payment.api.Client.IBuilder#timeout(long)
       */
      @Override
      public IBuilder timeout(long timeout) {
         if(timeout >= 0 && timeout <= Integer.MAX_VALUE) {
            instance.config.setConnectionTimeout((int) timeout);
            instance.config.setSocketTimeout((int) timeout);
         } else {
            // warn
         }
         return this;
      }

      /* (non-Javadoc)
       * @see com.adyen.payment.api.Client.IBuilder#connectionTimeout(long)
       */
      @Override
      public IBuilder connectionTimeout(long timeout) {
         if(timeout >= 0 && timeout <= Integer.MAX_VALUE) {
            instance.config.setConnectionTimeout((int) timeout);
         } else {
            // warn
         }
         return this;
      }

      /* (non-Javadoc)
       * @see com.adyen.payment.api.Client.IBuilder#socketTimeout(long)
       */
      @Override
      public IBuilder socketTimeout(long timeout) {
         if(timeout >= 0 && timeout <= Integer.MAX_VALUE) {
            instance.config.setSocketTimeout((int) timeout);
         } else {
            // warn
         }
         return this;
      }

      /* (non-Javadoc)
       * @see com.adyen.payment.api.Client.IBuilder#build()
       */
      @Override
      public Client build() {
         return instance;
      }

      /* (non-Javadoc)
       * @see com.adyen.payment.api.Client.IAccount#credentials(java.lang.String, java.lang.String)
       */
      @Override
      public IBuilder credentials(String username, String password) {
         if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            instance.config.setUsername(username);
            instance.config.setPassword(password);
         } else {
            throw new IllegalArgumentException("blank: username/password");
         }
         return this;
      }
   }
   
   /* (non-Javadoc)
    * @see com.adyen.payment.api.IClient#authorise(com.adyen.payment.api.model.PaymentRequest)
    */
   @Override
   public PaymentResponse authorise(PaymentRequest request) {
      if(request != null) {
         return Authorise.execute(config, request, false);
      } else {
         throw new IllegalArgumentException("blank: request");
      }
   }

   /* (non-Javadoc)
    * @see com.adyen.payment.api.IClient#authorise3ds(com.adyen.payment.api.model.PaymentRequest)
    */
   @Override
   public PaymentResponse authorise3ds(PaymentRequest request) {
      if(request != null) {
         return Authorise.execute(config, request, true);
      } else {
         throw new IllegalArgumentException("blank: request");
      }
   }

   /* (non-Javadoc)
    * @see com.adyen.payment.api.IClient#verifyBin(com.adyen.payment.api.model.PaymentRequest)
    */
   @Override
   public PaymentResponse verifyBin(PaymentRequest request) {
      if(request != null) {
         return Authorise.execute(config, request, false);
      } else {
         throw new IllegalArgumentException("blank: request");
      }
   }

   /* (non-Javadoc)
    * @see com.adyen.payment.api.IClient#capture(com.adyen.payment.api.model.ModificationRequest)
    */
   @Override
   public ModificationResponse capture(ModificationRequest request) {
      if(request != null) {
         return Capture.execute(config, request);
      } else {
         throw new IllegalArgumentException("blank: request");
      }
   }

   /* (non-Javadoc)
    * @see com.adyen.payment.api.IClient#cancel(com.adyen.payment.api.model.ModificationRequest)
    */
   @Override
   public ModificationResponse cancel(ModificationRequest request) {
      if(request != null) {
         return Cancel.execute(config, request);
      } else {
         throw new IllegalArgumentException("blank: request");
      }
   }

   /* (non-Javadoc)
    * @see com.adyen.payment.api.IClient#refund(com.adyen.payment.api.model.ModificationRequest)
    */
   @Override
   public ModificationResponse refund(ModificationRequest request) {
      if(request != null) {
         return Refund.execute(config, request);
      } else {
         throw new IllegalArgumentException("blank: request");
      }
   }

   /* (non-Javadoc)
    * @see com.adyen.payment.api.IClient#cancelOrRefund(com.adyen.payment.api.model.ModificationRequest)
    */
   @Override
   public ModificationResponse cancelOrRefund(ModificationRequest request) {
      if(request != null) {
         return CancelOrRefund.execute(config, request);
      } else {
         throw new IllegalArgumentException("blank: request");
      }
   }
}
