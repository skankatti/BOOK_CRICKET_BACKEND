package cricket.game.controller;

public class Respons<T> {

	private String message;

	/** The data. */
	private T data;

	public Respons(String message, T data) {
		super();
		this.message = message;
		this.data = data;
	}

	
}
