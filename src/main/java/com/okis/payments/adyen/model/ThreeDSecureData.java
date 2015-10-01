package com.okis.payments.adyen.model;

import static org.boon.Boon.toJson;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ThreeDSecureData implements Serializable {
    private String authenticationResponse;
    private String cavv;
    private String cavvAlgorithm;
    private String directoryResponse;
    private String eci;
    private String xid;

    public String getAuthenticationResponse() {
        return authenticationResponse;
    }

    public void setAuthenticationResponse(String authenticationResponse) {
        this.authenticationResponse = authenticationResponse;
    }

    public String getCavv() {
        return cavv;
    }

    public void setCavv(String cavv) {
        this.cavv = cavv;
    }

    public String getCavvAlgorithm() {
        return cavvAlgorithm;
    }

    public void setCavvAlgorithm(String cavvAlgorithm) {
        this.cavvAlgorithm = cavvAlgorithm;
    }

    public String getDirectoryResponse() {
        return directoryResponse;
    }

    public void setDirectoryResponse(String directoryResponse) {
        this.directoryResponse = directoryResponse;
    }

    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    @Override
    public String toString() {
        return toJson(this);
    }
}
