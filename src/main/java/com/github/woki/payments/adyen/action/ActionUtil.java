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
package com.github.woki.payments.adyen.action;

import static org.apache.http.client.fluent.Request.Post;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import com.github.woki.payments.adyen.APService;
import com.github.woki.payments.adyen.ClientConfig;
import com.github.woki.payments.adyen.model.ModificationResponse;
import com.github.woki.payments.adyen.model.PaymentResponse;
import io.advantageous.boon.json.JsonFactory;
import io.advantageous.boon.json.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
public final class ActionUtil {
    private ActionUtil() {
        // utility
    }

    private static final Logger LOG = LoggerFactory.getLogger(ActionUtil.class);
    private static final ObjectMapper MAPPER = JsonFactory.create();

    public static Request createPost(APService service, ClientConfig config, Object request) {
        Request retval = Post(config.getServices().get(service));
        // configure conn timeout
        retval.connectTimeout(config.getConnectionTimeout());
        // configure socket timeout
        retval.socketTimeout(config.getSocketTimeout());
        // add json
        retval.addHeader("Content-Type", "application/json");
        retval.addHeader("Accept", "application/json");
        for (Map.Entry<String, String> entry : config.getExtraParameters().entrySet()) {
            retval.addHeader(entry.getKey(), entry.getValue());
        }
        // add content
        retval.bodyString(MAPPER.toJson(request), ContentType.APPLICATION_JSON);
        return retval;
    }

    public static PaymentResponse handlePaymentResponse(final HttpResponse response) throws IOException {
        PaymentResponse retval;
        HttpOutcome httpOutcome = handleHttpResponse(response);
        if (httpOutcome.content != null) {
            retval = MAPPER.fromJson(httpOutcome.content, PaymentResponse.class);
        } else {
            retval = new PaymentResponse();
            retval.setStatus(httpOutcome.statusCode);
            retval.setMessage(httpOutcome.message);
        }
        if (httpOutcome.statusCode != HttpStatus.SC_OK) {
            LOG.warn("authorization failed: {} - {}", httpOutcome.statusCode, httpOutcome.message);
        }
        return retval;
    }

    public static ModificationResponse handleModificationResponse(final HttpResponse response) throws IOException {
        ModificationResponse retval;
        HttpOutcome httpOutcome = handleHttpResponse(response);
        if (httpOutcome.content != null) {
            retval = MAPPER.fromJson(httpOutcome.content, ModificationResponse.class);
        } else {
            retval = new ModificationResponse();
            retval.setStatus(httpOutcome.statusCode);
            retval.setMessage(httpOutcome.message);
        }
        if (httpOutcome.statusCode != HttpStatus.SC_OK) {
            LOG.warn("modification failed: {} - {}", httpOutcome.statusCode, httpOutcome.message);
        }
        return retval;
    }

    private static HttpOutcome handleHttpResponse(HttpResponse response) throws IOException {
        HttpOutcome retval = new HttpOutcome();
        StatusLine status = response.getStatusLine();
        HttpEntity entity = response.getEntity();
        if (entity == null) {
            LOG.error("blank: response");
            throw new ClientProtocolException("blank: response");
        }
        retval.statusCode = status.getStatusCode();
        boolean readContent = false;
        switch (status.getStatusCode()) {
            case HttpStatus.SC_OK:
                retval.message = "Request processed normally";
                readContent = true;
                break;
            case HttpStatus.SC_BAD_REQUEST:
                retval.message = "Problem reading or understanding request";
                readContent = true;
                break;
            case HttpStatus.SC_UNPROCESSABLE_ENTITY:
                retval.message = "Request validation error";
                readContent = true;
                break;
            case HttpStatus.SC_UNAUTHORIZED:
                retval.message = "Authentication required";
                break;
            case HttpStatus.SC_FORBIDDEN:
                retval.message = "Insufficient permission to process request";
                break;
            case HttpStatus.SC_NOT_FOUND:
                retval.message = "Service not found";
                break;
            default:
                retval.message = "Unexpected error";
        }
        if (readContent) {
            retval.content = new InputStreamReader(entity.getContent());
        }
        return retval;
    }

    private static class HttpOutcome {
        private int statusCode;
        private String message;
        private InputStreamReader content;
    }
}
