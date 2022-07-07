/**
 * 
 */
package in.ifms.employee.exception;

import java.time.LocalDateTime;

/**
 * 
 * This class stores the error information occurred in the system
 * 
 * @author Sharat Pradhan
 *
 */
public class ErrorDetails {

	/** time stamp of the error occurred */
	private LocalDateTime timeStamp;

	/** short description message of the error */
	private String message;

	/** detailed description message of the error */
	private String details;

	/**
	 * @param timeStamp
	 * @param message
	 * @param details
	 */
	public ErrorDetails(LocalDateTime timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	/**
	 * @return the timeStamp
	 */
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

}
