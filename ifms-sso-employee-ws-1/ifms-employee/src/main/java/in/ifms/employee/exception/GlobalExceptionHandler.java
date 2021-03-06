/**
 * 
 */
package in.ifms.employee.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import in.ifms.employee.constant.IFMSResponseCode;

/**
 * 
 * This class is the Request handler for the Exceptions thrown by the IFMS
 * System
 * 
 * 
 * @author Sharat Pradhan
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/** place holder for the Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 
	 */
	public GlobalExceptionHandler() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method defines the response when Resource Not Found - 404 of HTTP
	 * Response
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFound(Exception exception, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), IFMSResponseCode.FAILURE.getMessage(),
				webRequest.getDescription(false));
		LOGGER.error("Exception occured due Resource not found :: " + exception);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	/**
	 * This method wraps all Runtime Exceptions and sends the response as Internal
	 * Server Error - 500 in HTTP Response
	 * 
	 * 
	 */
	//Disabled now, since the parent exception gets more precedence than the specific one
	//@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalException(Exception exception, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), IFMSResponseCode.FAILURE.getMessage(),
				webRequest.getDescription(false));
		LOGGER.error("Global Exception occured :: " + exception);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * This method wraps the Database exceptions and sends the response as Internal
	 * Server Error - 500 in HTTP Response
	 */
	@ExceptionHandler({ DataAccessException.class, CannotCreateTransactionException.class })
	public ResponseEntity<?> dataAccessException(Exception exception, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), IFMSResponseCode.DATABASE_ERROR.getMessage(),
				webRequest.getDescription(false));
		LOGGER.error("Database Exception occured :: " + exception);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
