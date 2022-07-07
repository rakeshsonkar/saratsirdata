package com.eTrymasters.Response;

/*
 * Author - pawan
 * 
 */


import com.eTrymasters.constant.ApiStatus;
import com.eTrymasters.constant.ApiStatusCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName(value = "response")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class ApiResponse {

	@JsonProperty(value = "status")
	private ApiStatus status;
	
	@JsonProperty(value = "statusCode")
	private ApiStatusCode statusCode;

	@JsonProperty(value = "message")
	private String message;

	@JsonProperty(value = "exception")
	private String exception;

	@JsonProperty(value = "data")
	private Object data;

	/**
	 * @param status
	 * @param message
	 */
	public ApiResponse(ApiStatus status, ApiStatusCode statusCode , String message) {
		this.status = status;
		this.message = message;
		this.statusCode=statusCode;
	}

	/**
	 * @param status
	 * @param message
	 * @param data
	 */
	public ApiResponse(ApiStatus status,ApiStatusCode statusCode, String message, Object data) {
		this.status = status;
		this.message = message;
		this.statusCode=statusCode;
		this.data = data;
	}

	/**
	 * @param status
	 * @param message
	 * @param exception
	 */
	public ApiResponse(ApiStatus status,ApiStatusCode statusCode ,String message, String exception) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode=statusCode;
		this.exception = exception;
	}

	/**
	 * @param status
	 * @param message
	 * @param exception
	 * @param data
	 */
	public ApiResponse(ApiStatus status, ApiStatusCode statusCode,String message, String exception, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode=statusCode;
		this.exception = exception;
		this.data = data;
	}

	/**
	 * @return the status
	 */
	public ApiStatus getStatus() {
		return status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the exception
	 */
	public String getException() {
		return exception;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

}