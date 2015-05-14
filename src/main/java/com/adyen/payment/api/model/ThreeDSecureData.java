package com.adyen.payment.api.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ThreeDSecureData implements Serializable {
	private String authenticationResponse;
	private String cavv;
	private String cavvAlgorithm;
	private String directoryResponse;
	private String eci;
	private String xid;
	
	public ThreeDSecureData() {
	}

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
		StringBuilder builder = new StringBuilder();
		builder.append("ThreeDSecureData [");
		if (authenticationResponse != null) {
			builder.append("authenticationResponse=");
			builder.append(authenticationResponse);
			builder.append(", ");
		}
		if (cavv != null) {
			builder.append("cavv=");
			builder.append(cavv);
			builder.append(", ");
		}
		if (cavvAlgorithm != null) {
			builder.append("cavvAlgorithm=");
			builder.append(cavvAlgorithm);
			builder.append(", ");
		}
		if (directoryResponse != null) {
			builder.append("directoryResponse=");
			builder.append(directoryResponse);
			builder.append(", ");
		}
		if (eci != null) {
			builder.append("eci=");
			builder.append(eci);
			builder.append(", ");
		}
		if (xid != null) {
			builder.append("xid=");
			builder.append(xid);
		}
		builder.append("]");
		return builder.toString();
	}
}
