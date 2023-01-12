package cricket.game.Exception;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Service
public class Response extends RuntimeException{

	public Response() {}
	
	public Response(String msg) {
		super(msg);
	}
	
}
