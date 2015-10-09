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
package com.github.woki.payments.adyen.model;

import static io.advantageous.boon.json.JsonFactory.toJson;

import java.io.Serializable;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial, unused")
public class FraudResultItem implements Serializable {
    private String accountScore;
    private String checkId;
    private String name;

    public FraudResultItem() {
        // noop ctor
    }

    public FraudResultItem(String name, String checkId, String accountScore) {
        this.accountScore = accountScore;
        this.checkId = checkId;
        this.name = name;
    }

    public String getAccountScore() {
        return accountScore;
    }

    public void setAccountScore(String accountScore) {
        this.accountScore = accountScore;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return toJson(this);
    }
}
