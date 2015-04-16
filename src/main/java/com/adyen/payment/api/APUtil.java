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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
public class APUtil {
   public static final Map<APService, URL> TEST_SERVICES;
   public static final Map<APService, URL> LIVE_SERVICES;
   
   static {
      TEST_SERVICES = new HashMap<>();
      try {
         TEST_SERVICES.put(APService.AUTHORISATION, new URL("https://pal-test.adyen.com/pal/servlet/Payment/v12/authorise"));
         TEST_SERVICES.put(APService.AUTHORISATION_3D, new URL("https://pal-live.adyen.com/pal/servlet/Payment/v12/authorise3d"));
         TEST_SERVICES.put(APService.CAPTURE, new URL("https://pal-test.adyen.com/pal/servlet/Payment/v12/capture"));
         TEST_SERVICES.put(APService.REFUND, new URL("https://pal-test.adyen.com/pal/servlet/Payment/v12/refund"));
         TEST_SERVICES.put(APService.CANCEL, new URL("https://pal-test.adyen.com/pal/servlet/Payment/v12/cancel"));
         TEST_SERVICES.put(APService.CANCEL_OR_REFUND, new URL("https://pal-test.adyen.com/pal/servlet/Payment/v12/cancelorrefund"));
      } catch(Exception e) {
         ;
      }
      LIVE_SERVICES = new HashMap<>();
      try {
         LIVE_SERVICES.put(APService.AUTHORISATION, new URL("https://pal-live.adyen.com/pal/servlet/Payment/v12/authorise"));
         LIVE_SERVICES.put(APService.AUTHORISATION_3D, new URL("https://pal-live.adyen.com/pal/servlet/Payment/v12/authorise3d"));
         LIVE_SERVICES.put(APService.CAPTURE, new URL("https://pal-live.adyen.com/pal/servlet/Payment/v12/capture"));
         LIVE_SERVICES.put(APService.REFUND, new URL("https://pal-live.adyen.com/pal/servlet/Payment/v12/refund"));
         LIVE_SERVICES.put(APService.CANCEL, new URL("https://pal-live.adyen.com/pal/servlet/Payment/v12/cancel"));
         LIVE_SERVICES.put(APService.CANCEL_OR_REFUND, new URL("https://pal-live.adyen.com/pal/servlet/Payment/v12/cancelorrefund"));
      } catch(Exception e) {
         ;
      }
   }
   
   public enum ReferenceType {
      DATE,
      TIMESTAMP,
      UUID;
   }
   
   public static String reference(ReferenceType type) {
      String retval = null;
      switch(type) {
      case TIMESTAMP:
         retval = String.valueOf(System.currentTimeMillis());
         break;
      case UUID:
         retval = UUID.randomUUID().toString();
         break;
      default:
         retval = new Date().toString();
      }
      return retval;
   }
}
