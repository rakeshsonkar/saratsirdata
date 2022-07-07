/**
 * 
 */
package in.ifms.employee.response;

import java.io.Serializable;

/**
 * @author hp
 *
 *
 *         This is the IFMSResponse class for sending System Response codes and
 *         messages
 */
public class IFMSResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String responseCode;

	private String responseMessage;

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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
