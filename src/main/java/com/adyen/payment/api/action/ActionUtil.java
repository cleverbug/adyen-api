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

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adyen.payment.api.model.PaymentResponse;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
public class ActionUtil {
	private static final Logger LOG = LoggerFactory.getLogger(ActionUtil.class);
	private static final ObjectMapper MAPPER = JsonFactory.create();
	
	public static Request createPost(String url, int connectTimeout,
			int socketTimeout, String proxyUser, final Object request) {
		Request retval = Post(url);
		// configure conn timeout
		if (connectTimeout > 0) {
			retval.connectTimeout(connectTimeout);
		}
		// configure socket timeout
		if (socketTimeout > 0) {
			retval.socketTimeout(socketTimeout);
		}
		// add json
		retval.addHeader("Content-Type", "application/json");
		retval.addHeader("Accept", "application/json");
		if (StringUtils.isNotBlank(proxyUser)) {
			retval.addHeader("j_proxyuser", proxyUser);
		}
		// add content
		retval.bodyString(MAPPER.toJson(request), ContentType.APPLICATION_JSON);
		return retval;
	}
	
	public static PaymentResponse handlePaymentResponse(final HttpResponse response)
			throws ClientProtocolException, IOException {
		PaymentResponse retval = null;
		HttpOutcome httpOutcome = handleHttpResponse(response);
		if(httpOutcome.content != null) {
			retval = MAPPER.fromJson(httpOutcome.content,
					PaymentResponse.class);
		} else {
			retval = new PaymentResponse();
			retval.setStatus(httpOutcome.statusCode);
			retval.setMessage(httpOutcome.message);
		}
		if (httpOutcome.statusCode != HttpStatus.SC_OK) {
			LOG.warn("unable to process request: {}",
					httpOutcome.statusCode);
		}
		return retval;
	}
	
	private static HttpOutcome handleHttpResponse(HttpResponse response)
			throws ClientProtocolException, IOException {
		HttpOutcome retval = new HttpOutcome();
		StatusLine status = response.getStatusLine();
		HttpEntity entity = response.getEntity();
		if (entity == null) {
			LOG.error("blank: response");
			throw new ClientProtocolException(
					"blank: response");
		}
		retval.statusCode = status.getStatusCode();
		switch (status.getStatusCode()) {
		case HttpStatus.SC_OK:
		case HttpStatus.SC_BAD_REQUEST:
		case HttpStatus.SC_UNPROCESSABLE_ENTITY:
			retval.content = new InputStreamReader(
					entity.getContent());
			break;
		case HttpStatus.SC_UNAUTHORIZED:
			retval.message = "Unauthorized operation";
			break;
		case HttpStatus.SC_FORBIDDEN:
			retval.message = "Forbidden operation";
			break;
		case HttpStatus.SC_NOT_FOUND:
			retval.message = "Service not found";
			break;
		default:
			retval.message = "Unexpected error";
		}
		return retval;
	}
	
	private static class HttpOutcome {
		private int statusCode;
		private String message;
		private InputStreamReader content;
	}
}
