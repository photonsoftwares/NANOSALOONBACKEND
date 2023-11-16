package com.Img.photon.saloon.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	private boolean status;

	public CustomException(boolean status, String message) {
		super(message, new Throwable(message));
		this.status = status;
		this.message = message;
	}

	public CustomException(String message) {
		super(message);
		message = message;
	}

}
