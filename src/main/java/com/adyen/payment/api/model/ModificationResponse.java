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
public class ModificationResponse extends Error implements Serializable {
	private Map<String, String> additionalData = new HashMap<String, String>();
	private String pspReference;
	private String response;

	public ModificationResponse() {
	}

	/**
	 * @return the pspReference
	 */
	public String getPspReference() {
		return pspReference;
	}

	/**
	 * @param pspReference
	 *            the pspReference to set
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
	 * @param response
	 *            the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * @return the additionalData
	 */
	public Map<String, String> getAdditionalData() {
		return additionalData;
	}

	/**
	 * @param additionalData
	 *            the additionalData to set
	 */
	public void setAdditionalData(Map<String, String> additionalData) {
		this.additionalData = additionalData;
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext()
				&& i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("ModificationResponse [");
		if (additionalData != null) {
			builder.append("additionalData=");
			builder.append(toString(additionalData.entrySet(), maxLen));
			builder.append(", ");
		}
		if (pspReference != null) {
			builder.append("pspReference=");
			builder.append(pspReference);
			builder.append(", ");
		}
		if (response != null) {
			builder.append("response=");
			builder.append(response);
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
