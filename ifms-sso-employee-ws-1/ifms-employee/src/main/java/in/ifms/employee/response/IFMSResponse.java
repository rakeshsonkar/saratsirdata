/**
 * 
 */
package in.ifms.employee.response;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import in.ifms.employee.constant.ApiStatus;

/**
 * @author Sharat Pradhan
 *
 *
 *         This is the IFMSResponse class for sending System Response codes and
 *         messages as a part of HTTP Response Body
 */
@JsonInclude(value = Include.NON_EMPTY)
@JsonRootName(value = "response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class IFMSResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "status")
	private ApiStatus responseStatus;

	@JsonProperty(value = "statusCode")
	private String responseCode;

	@JsonProperty(value = "message")
	private String responseMessage;

	@JsonProperty(value = "exception")
	private String exception;

	private Object data;

	/**
	 * 
	 */
	public IFMSResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param responseCode
	 * @param responseMessage
	 */
	public IFMSResponse(String responseCode, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	/**
	 * @param responseStatus
	 * @param responseCode
	 * @param responseMessage
	 */
	public IFMSResponse(ApiStatus responseStatus, String responseCode, String responseMessage) {
		super();
		this.responseStatus = responseStatus;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	/**
	 * @param responseStatus
	 * @param responseCode
	 * @param responseMessage
	 * @param exception
	 */
	public IFMSResponse(ApiStatus responseStatus, String responseCode, String responseMessage, String exception) {
		super();
		this.responseStatus = responseStatus;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.exception = exception;
	}

	/**
	 * @return the responseStatus
	 */
	public ApiStatus getResponseStatus() {
		return responseStatus;
	}

	/**
	 * @param responseStatus the responseStatus to set
	 */
	public void setResponseStatus(ApiStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param responseMessage the responseMessage to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	/**
	 * @return the exception
	 */
	public String getException() {
		return exception;
	}

	/**
	 * @param exception the exception to set
	 */
	public void setException(String exception) {
		this.exception = exception;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, exception, responseCode, responseMessage, responseStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IFMSResponse other = (IFMSResponse) obj;
		return Objects.equals(data, other.data) && Objects.equals(exception, other.exception)
				&& Objects.equals(responseCode, other.responseCode)
				&& Objects.equals(responseMessage, other.responseMessage) && responseStatus == other.responseStatus;
	}

	@Override
	public String toString() {
		return "IFMSResponse [responseStatus=" + responseStatus + ", responseCode=" + responseCode
				+ ", responseMessage=" + responseMessage + ", exception=" + exception + ", data=" + data + "]";
	}

}
