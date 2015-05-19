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

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
public class PaymentRequestBuilder {
	private PaymentRequestBuilder() {
	}

	public static IAmount merchantAccount(String account) {
		return new Builder(account);
	}

	public interface IAmount {
		IBuilder amount(Amount amount);
	}

	public interface IBuilder {
		IBuilder card(Card card);

		IBuilder reference(String reference);

		IBuilder shopperEmail(String email);

		IBuilder shopperIP(String ip);

		IBuilder shopperReference(String reference);

		IBuilder shopperInteraction(ShopperInteraction interaction);

		IBuilder shopper(Name name, String email, String ip, String reference,
				ShopperInteraction interaction);

		IBuilder fraudOffset(int offset);

		IBuilder mcc(int mcc);

		IBuilder merchantOrderReference(String reference);

		IBuilder selectedBrand(String brand);

		IBuilder additionalField(String key, String value);

		IBuilder additionalFields(Map<String, String> fields);

		IBuilder browserInfo(String userAgent, String acceptHeader);

		IBuilder browserInfo(BrowserInfo info);

		IBuilder md(String md);

		IBuilder paResponse(String response);

		IBuilder billingAddress(BillingAddress address);

		IBuilder additionalAmount(Amount amount);

		IBuilder installments(int value);

		IBuilder shopperName(Name name);
		
		// shopperLocale, telephoneNumber, shopperName, firstName, lastName, dateOfBirth, shopperStatement, socialSecurityNumber
		// deliveryDate
		// deliveryAddress
		// captureDelayHours
		// deviceFingerprint
		// mpiData
		// recurring
		// dccQuote
		// selectedRecurringDetailReference
		// sessionId

		PaymentRequest build();
	}

	private static class Builder implements IAmount, IBuilder {
		private PaymentRequest request;

		Builder(String merchantAccount) {
			if (StringUtils.isNotBlank(merchantAccount)) {
				request = new PaymentRequest();
				request.setMerchantAccount(merchantAccount);
			} else {
				// warn throw new
				// IllegalArgumentException("blank: merchantAccount");
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#card(com
		 * .adyen.payment.api.model.Card)
		 */
		@Override
		public IBuilder card(Card card) {
			if (card != null) {
				request.setCard(card);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#reference
		 * (java.lang.String)
		 */
		@Override
		public IBuilder reference(String reference) {
			if (StringUtils.isNotBlank(reference)) {
				request.setReference(reference);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#shopperEmail
		 * (java.lang.String)
		 */
		@Override
		public IBuilder shopperEmail(String email) {
			if (StringUtils.isNotBlank(email)) {
				request.setShopperEmail(email);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#shopperIP
		 * (java.lang.String)
		 */
		@Override
		public IBuilder shopperIP(String ip) {
			if (StringUtils.isNotBlank(ip)) {
				request.setShopperIP(ip);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#
		 * shopperRefference(java.lang.String)
		 */
		@Override
		public IBuilder shopperReference(String reference) {
			if (StringUtils.isNotBlank(reference)) {
				request.setShopperReference(reference);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#
		 * shopperInteraction(com.adyen.payment.api.model.ShopperInteraction)
		 */
		@Override
		public IBuilder shopperInteraction(ShopperInteraction interaction) {
			if (interaction != null) {
				request.setShopperInteraction(interaction);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#shopper
		 * (java.lang.String, java.lang.String, java.lang.String,
		 * com.adyen.payment.api.model.ShopperInteraction)
		 */
		@Override
		public IBuilder shopper(Name name, String email, String ip, String reference,
				ShopperInteraction interaction) {
			shopperName(name);
			shopperEmail(email);
			shopperIP(ip);
			shopperReference(reference);
			shopperInteraction(interaction);
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IAmount#amount(
		 * com.adyen.payment.api.model.Amount)
		 */
		@Override
		public IBuilder amount(Amount amount) {
			if (amount != null) {
				request.setAmount(amount);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#build()
		 */
		@Override
		public PaymentRequest build() {
			return request;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#fraudOffset
		 * (long)
		 */
		@Override
		public IBuilder fraudOffset(int offset) {
			request.setFraudOffset(offset);
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#mcc(int)
		 */
		@Override
		public IBuilder mcc(int mcc) {
			if (mcc >= 0 && mcc <= 9999) {
				request.setMcc(mcc);
			} else {
				// warn throw new
				// IllegalArgumentException("invalid range: mcc: " + mcc);
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#
		 * merchantOrderReference(java.lang.String)
		 */
		@Override
		public IBuilder merchantOrderReference(String reference) {
			if (StringUtils.isNotBlank(reference)) {
				request.setMerchantOrderReference(reference);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#selectedBrand
		 * (java.lang.String)
		 */
		@Override
		public IBuilder selectedBrand(String brand) {
			if (StringUtils.isNotBlank(brand)) {
				request.setSelectedBrand(brand);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#
		 * additionalField(java.lang.String, java.lang.String)
		 */
		@Override
		public IBuilder additionalField(String key, String value) {
			if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
				request.getAdditionalFields().put(key, value);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#
		 * additionalFields(java.util.Map)
		 */
		@Override
		public IBuilder additionalFields(Map<String, String> fields) {
			if (fields != null && fields.size() > 0) {
				request.setAdditionalFields(fields);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#browserInfo
		 * (java.lang.String, java.lang.String)
		 */
		@Override
		public IBuilder browserInfo(String userAgent, String acceptHeader) {
			if (StringUtils.isNotBlank(userAgent)
					&& StringUtils.isNotBlank(acceptHeader)) {
				request.setBrowserInfo(new BrowserInfo(userAgent, acceptHeader));
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#browserInfo
		 * (com.adyen.payment.api.model.BrowserInfo)
		 */
		@Override
		public IBuilder browserInfo(BrowserInfo info) {
			if (info != null) {
				request.setBrowserInfo(info);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#md(java
		 * .lang.String)
		 */
		@Override
		public IBuilder md(String md) {
			if (StringUtils.isNotBlank(md)) {
				request.setMd(md);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#paResponse
		 * (java.lang.String)
		 */
		@Override
		public IBuilder paResponse(String response) {
			if (StringUtils.isNotBlank(response)) {
				request.setPaResponse(response);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#billingAddress
		 * (com.adyen.payment.api.model.BillingAddress)
		 */
		@Override
		public IBuilder billingAddress(BillingAddress address) {
			if (address != null) {
				request.setBillingAddress(address);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#
		 * additionalAmount(com.adyen.payment.api.model.Amount)
		 */
		@Override
		public IBuilder additionalAmount(Amount amount) {
			if (amount != null) {
				request.setAdditionalAmount(amount);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.PaymentRequestBuilder.IBuilder#installments
		 * (int)
		 */
		@Override
		public IBuilder installments(int value) {
			if (value > 0) {
				request.setInstallments(new Installments(value));
			} else {
				// warn
			}
			return this;
		}

		@Override
		public IBuilder shopperName(Name name) {
			if (name != null) {
				request.setShopperName(name);
			} else {
				// warn
			}
			return this;
		}
	}
}
