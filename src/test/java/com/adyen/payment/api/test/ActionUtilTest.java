package com.adyen.payment.api.test;

import com.adyen.payment.api.action.ActionUtil;
import org.apache.http.client.fluent.Request;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by willian on 9/21/15.
 */
public class ActionUtilTest {

    @Test
    public void testCreatePost() throws Exception {
        String url = "http://www.adyen.com", proxyUser = "proxy-user";
        int connTimeout = 0, socketTimeout = 0;
        Request request = ActionUtil.createPost(url, connTimeout, socketTimeout, proxyUser, null);
        Assert.assertNotNull(request);
        System.out.println(request.toString());
    }

    @Test
    public void testHandlePaymentResponse() throws Exception {

    }

    @Test
    public void testHandleModificationResponse() throws Exception {

    }
}