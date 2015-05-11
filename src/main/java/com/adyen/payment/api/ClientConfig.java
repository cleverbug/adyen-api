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

import java.io.Serializable;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
@SuppressWarnings("serial")
public class ClientConfig implements Serializable {
	private int connectionTimeout;
	private int socketTimeout;
	private Map<APService, URL> services = new HashMap<>();
	private String username, password, proxyUser;

	public ClientConfig() {
	}

	/**
	 * connectionTimeout (em milissegundos) refere-se ao parametro
	 * http.connection.timeout (httpclient). O valor 0 (default) siginifica que
	 * nao ha timeout (blocking).
	 * 
	 * @return
	 */
	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	/**
	 * socketTimeout (em milissegundos) refere-se ao parametro
	 * http.socket.timeout (httpcliet). O valor 0 (default) siginifica que nao
	 * ha timeout (blocking).
	 * 
	 * @return
	 */
	public int getSocketTimeout() {
		return socketTimeout;
	}

	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	/**
	 * @return the services
	 */
	public Map<APService, URL> getServices() {
		return services;
	}

	/**
	 * @param services
	 *            the services to set
	 */
	public void setServices(Map<APService, URL> services) {
		this.services = services;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getProxyUser() {
		return proxyUser;
	}

	public void setProxyUser(String proxyUser) {
		this.proxyUser = proxyUser;
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

	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("ClientConfig [connectionTimeout=");
		builder.append(connectionTimeout);
		builder.append(", socketTimeout=");
		builder.append(socketTimeout);
		builder.append(", ");
		if (services != null) {
			builder.append("services=");
			builder.append(toString(services.entrySet(), maxLen));
			builder.append(", ");
		}
		if (username != null) {
			builder.append("username=");
			builder.append(username);
			builder.append(", ");
		}
		if (password != null) {
			builder.append("password=********, ");
		}
		if (proxyUser != null) {
			builder.append("proxyUser=");
			builder.append(proxyUser);
		}
		builder.append("]");
		return builder.toString();
	}
}
