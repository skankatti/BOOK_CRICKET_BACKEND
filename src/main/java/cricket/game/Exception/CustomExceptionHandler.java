package cricket.game.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomExceptionHandler {

	@ExceptionHandler(InputException.class)
	public ResponseEntity<?> userInputException(InputException ie) {
		InputException InputException = new InputException();
		
		return new ResponseEntity<>(InputException,ie.getResponseStatus());

	}
}
//comment
//test
//test 1s