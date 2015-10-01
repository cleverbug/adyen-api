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
package com.okis.payments.adyen.model;

import static org.boon.Boon.toJson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial")
public class FraudResult implements Serializable {
    private String accountScore;
    private List<FraudResultItem> results = new ArrayList<>();

    public FraudResult() {
        // noop ctor
    }

    public String getAccountScore() {
        return accountScore;
    }

    public void setAccountScore(String accountScore) {
        this.accountScore = accountScore;
    }

    public List<FraudResultItem> getResults() {
        return results;
    }

    public void setResults(List<FraudResultItem> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return toJson(this);
    }
}
