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

import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
public class CardBuilder {
	private CardBuilder() {
	}

	public static ICvc number(String number) {
		return new Builder(number);
	}

	public interface ICvc {
		IExpiry cvc(String cvc);
	}

	public interface IExpiry {
		IHolder expiry(int year, int month);
	}

	public interface IHolder {
		IBuilder holder(String holder);
	}

	public interface IBuilder {
		Card build();
	}

	private static class Builder implements IBuilder, ICvc, IExpiry, IHolder {
		private Card card;

		Builder(String number) {
			if (StringUtils.isNotBlank(number)) {
				card = new Card();
				card.setNumber(number);
			} else {
				throw new IllegalArgumentException("blank: number");
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.CardBuilder.IHolder#holder(java.lang.
		 * String)
		 */
		@Override
		public IBuilder holder(String holder) {
			if (StringUtils.isNotBlank(holder)) {
				card.setHolderName(holder);
			} else {
				throw new IllegalArgumentException("blank: holder");
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.adyen.payment.api.model.CardBuilder.IExpiry#expiry(int, int)
		 */
		@Override
		public IHolder expiry(int year, int month) {
			if (year >= Calendar.getInstance().get(Calendar.YEAR) && month > 0
					&& month < 13) {
				card.setExpiryMonth(month);
				card.setExpiryYear(year);
			} else {
				throw new IllegalArgumentException(
						"invalid: expiry month/year: " + month + "/" + year);
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.CardBuilder.ICvc#cvc(java.lang.String)
		 */
		@Override
		public IExpiry cvc(String cvc) {
			if (StringUtils.isNotBlank(cvc)) {
				card.setCvc(cvc);
			} else {
				throw new IllegalArgumentException("blank: cvc");
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.adyen.payment.api.model.CardBuilder.IBuilder#build()
		 */
		@Override
		public Card build() {
			return card;
		}
	}
}
