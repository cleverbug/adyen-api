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

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
public class NameBuilder {
	private NameBuilder() {
	}

	public static ILastName firstName(String firstName) {
		return new Builder(firstName);
	}

	public interface ILastName {
		IBuilder lastName(String lastName);
	}

	public interface IBuilder {
		IBuilder gender(GenderType gender);
		IBuilder infix(String infix);
		
		Name build();
	}

	private static class Builder implements IBuilder, ILastName {
		private Name name;

		Builder(String firstName) {
			if (StringUtils.isNotBlank(firstName)) {
				name = new Name();
				name.setFirstName(firstName);
			} else {
				throw new IllegalArgumentException("blank: firstName");
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.adyen.payment.api.model.CardBuilder.IBuilder#build()
		 */
		@Override
		public Name build() {
			return name;
		}

		@Override
		public IBuilder lastName(String lastName) {
			if(StringUtils.isNotBlank(lastName)) {
				name.setLastName(lastName);
			} else {
				// warn
			}
			return this;
		}

		@Override
		public IBuilder gender(GenderType gender) {
			if(gender != null) {
				name.setGender(gender);
			} else {
				// warn
			}
			return this;
		}

		@Override
		public IBuilder infix(String infix) {
			if(StringUtils.isNotBlank(infix)) {
				name.setInfix(infix);
			} else {
				// warn
			}
			return this;
		}
	}
}
