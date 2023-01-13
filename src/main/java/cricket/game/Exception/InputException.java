package cricket.game.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class InputException extends RuntimeException{

	
	public InputException() {}
	
	private String message;
	private HttpStatus responseStatus;
	
	public InputException(String message, HttpStatus responseStatus) {
		super();
		this.message = message;
		this.responseStatus = responseStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(HttpStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	
	
}
