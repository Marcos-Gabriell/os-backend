package br.com.marcos.services.exeptions;

public class DataIntegratyViolationExeception extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DataIntegratyViolationExeception(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegratyViolationExeception(String message) {
		super(message);
	}
}
