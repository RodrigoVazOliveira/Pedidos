package br.com.rvz.pedidos.exceptions;

public class InputError {
	
	private String input;
	private String message;

	public InputError() {
	}
	
	

	public InputError(String input, String message) {
		this.input = input;
		this.message = message;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
