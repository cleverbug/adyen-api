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
package com.okis.payments.adyen.action;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import com.okis.payments.adyen.APService;
import com.okis.payments.adyen.ClientConfig;
import com.okis.payments.adyen.error.APSAccessException;
import com.okis.payments.adyen.error.APSConfigurationException;
import com.okis.payments.adyen.model.ModificationRequest;
import com.okis.payments.adyen.model.ModificationResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
public class CancelOrRefund {
    private static final Logger LOG = LoggerFactory.getLogger(CancelOrRefund.class);

    private static Request createRequest(ClientConfig config, ModificationRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("config: {}, request: {}", config, request);
        }
        Request retval;
        String url;
        // create a Post
        try {
            url = config.getServices().get(APService.CANCEL_OR_REFUND);
        } catch (Exception e) {
            LOG.error("cancelOrRefund: missing parameter: url");
            throw new APSConfigurationException("cancelOrRefund: missing parameter: url");
        }
        if (StringUtils.isNotBlank(url)) {
            retval = ActionUtil.createPost(url, config.getConnectionTimeout(), config.getSocketTimeout(), config.getProxyUser(), request);
        } else {
            LOG.error("cancelOrRefund: missing parameter: url");
            throw new APSConfigurationException("cancelOrRefund: missing parameter: url");
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("retval: {}", retval);
        }
        return retval;
    }

    public static ModificationResponse execute(@NotNull ClientConfig config, @NotNull ModificationRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("config: {}, request: {}", config, request);
        }
        ModificationResponse retval;
        // create the request
        Request req = createRequest(config, request);
        // create an Executor
        Executor exec = Executor.newInstance();
        // add auth
        exec.auth(config.getUsername(), config.getPassword());
        // execute and handle
        try {
            retval = exec.execute(req).handleResponse(new ResponseHandler<ModificationResponse>() {
                public ModificationResponse handleResponse(HttpResponse response) throws IOException {
                    ModificationResponse modres = ActionUtil.handleModificationResponse(response);
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("modres: {}", modres);
                    }
                    return modres;
                }
            });
        } catch (Exception e) {
            LOG.error("cancelOrRefund", e);
            throw new APSAccessException("cancelOrRefund", e);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("retval: {}", retval);
        }
        return retval;
    }
}