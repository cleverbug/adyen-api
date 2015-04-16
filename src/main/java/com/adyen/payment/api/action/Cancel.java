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
package com.adyen.payment.api.action;

import static org.apache.http.client.fluent.Request.Post;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;

import com.adyen.payment.api.APService;
import com.adyen.payment.api.ClientConfig;
import com.adyen.payment.api.error.APSAccessException;
import com.adyen.payment.api.error.APSConfigurationException;
import com.adyen.payment.api.model.CancelRequest;
import com.adyen.payment.api.model.CancelResponse;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
public class Cancel {
   private static final ObjectMapper MAPPER = JsonFactory.create();
   
   private static Request createRequest(final ClientConfig config, final CancelRequest request) {
      Request retval = null;
      String url;
      // create a Post
      try {
         url = config.getServices().get(APService.CANCEL).toString();
      } catch(Exception e) {
         throw new APSConfigurationException("cancel: missing parameter: url");
      }
      if(StringUtils.isNotBlank(url)) {
         retval = Post(url);
         // configure conn timeout
         if(config.getConnectionTimeout() > 0) {
            retval.connectTimeout(config.getConnectionTimeout());
         }
         // configure socket timeout
         if(config.getSocketTimeout() > 0) {
            retval.socketTimeout(config.getSocketTimeout());
         }
         // add json
         retval.addHeader("Accept", "application/json");
         // add content
         retval.bodyString(MAPPER.toJson(request), ContentType.APPLICATION_JSON);
      } else {
         throw new APSConfigurationException("cancel: missing parameter: url");
      }
      return retval;
   }
   
   public static CancelResponse execute(final ClientConfig config, final CancelRequest request) {
      CancelResponse retval = null;
      // create the request
      Request req = createRequest(config, request);
      // create an Executor
      Executor exec = Executor.newInstance();
      // add auth
      exec.auth(config.getUsername(), config.getPassword());
      // execute and handle
      try {
         retval = exec.execute(req).handleResponse(
            new ResponseHandler<CancelResponse>() {
               public CancelResponse handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                  CancelResponse retval = new CancelResponse();
                  StatusLine status = response.getStatusLine();
                  HttpEntity entity = response.getEntity();
                  if(status.getStatusCode() != 200) {
                     String content = null;
                     if(entity != null) {
                        try {
                           content = IOUtils.toString(new InputStreamReader(entity.getContent()));
                        } catch(Exception e) {
                           ;
                        }
                     }
                     String reason = StringUtils.isNotBlank(content) ? status.getReasonPhrase() + " [" + content + "]"
                           : status.getReasonPhrase();
                     throw new HttpResponseException(status.getStatusCode(), reason);
                  }
                  if(entity == null) {
                     throw new ClientProtocolException("blank: cancel response");
                  }
                  retval = MAPPER.fromJson(new InputStreamReader(entity.getContent()), CancelResponse.class);
                  return retval;
               }
            }
         );
      } catch(Exception e) {
         throw new APSAccessException("cancel", e);
      }
      return retval;
   }
}
