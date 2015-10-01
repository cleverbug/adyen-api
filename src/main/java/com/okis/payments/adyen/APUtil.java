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
package com.okis.payments.adyen;

import static org.boon.Maps.map;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
public final class APUtil {
    private APUtil() {
        // utility
    }

    public static final Map<APService, String> TEST_SERVICES;
    public static final Map<APService, String> LIVE_SERVICES;

    static {
        TEST_SERVICES = map(
                APService.AUTHORISATION, "https://pal-test.adyen.com/pal/servlet/Payment/v12/authorise",
                APService.AUTHORISATION_3D, "https://pal-live.adyen.com/pal/servlet/Payment/v12/authorise3d",
                APService.CAPTURE, "https://pal-test.adyen.com/pal/servlet/Payment/v12/capture",
                APService.REFUND, "https://pal-test.adyen.com/pal/servlet/Payment/v12/refund",
                APService.CANCEL, "https://pal-test.adyen.com/pal/servlet/Payment/v12/cancel",
                APService.CANCEL_OR_REFUND, "https://pal-test.adyen.com/pal/servlet/Payment/v12/cancelorrefund");
        LIVE_SERVICES = map(
                APService.AUTHORISATION, "https://pal-live.adyen.com/pal/servlet/Payment/v12/authorise",
                APService.AUTHORISATION_3D, "https://pal-live.adyen.com/pal/servlet/Payment/v12/authorise3d",
                APService.CAPTURE, "https://pal-live.adyen.com/pal/servlet/Payment/v12/capture",
                APService.REFUND, "https://pal-live.adyen.com/pal/servlet/Payment/v12/refund",
                APService.CANCEL, "https://pal-live.adyen.com/pal/servlet/Payment/v12/cancel",
                APService.CANCEL_OR_REFUND, "https://pal-live.adyen.com/pal/servlet/Payment/v12/cancelorrefund");
    }

    public enum ReferenceType {
        DATE, TIMESTAMP, UUID
    }

    public static String reference(ReferenceType type) {
        String retval = null;
        switch (type) {
            case TIMESTAMP:
                retval = String.valueOf(System.currentTimeMillis());
                break;
            case UUID:
                retval = UUID.randomUUID().toString();
                break;
            case DATE:
                retval = new Date().toString();
                break;
        }
        return retval;
    }
}
