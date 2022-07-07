package com.bfc.constant;

public enum ApiStatus {

	/**
	 * API call is successful
	 */
	SUCCESS("SUCCESS"),

	/**
	 * API call is unsuccessful due to some error
	 */
	FAILED("FAILED"),

	/**
	 * Error occurred in API call
	 */
	ERROR("ERROR");

	private String status;

	ApiStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public String status() {
		return this.status;
	}
}