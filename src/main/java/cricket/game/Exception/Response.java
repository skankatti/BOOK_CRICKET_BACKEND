package cricket.game.Exception;

import org.springframework.stereotype.Component;

@Component
public class Response extends RuntimeException{

	public Response() {}
	
	public Response(String msg) {
		super(msg);
	}
	
}
