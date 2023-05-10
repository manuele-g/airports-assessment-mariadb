package com.developer.assessment.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

public class MyInternalErrorException extends RuntimeException {

	private static final long serialVersionUID = -2577381202718475033L;

	private static final HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

	private final String code;

	public MyInternalErrorException() {
		super();
		this.code = StringUtils.EMPTY;
	}

	public MyInternalErrorException(String message, Throwable cause) {
		super(message, cause);
		this.code = StringUtils.EMPTY;
	}

	public MyInternalErrorException(String message) {
		super(message);
		this.code = StringUtils.EMPTY;
	}

	public MyInternalErrorException(Throwable cause) {
		super(cause);
		this.code = StringUtils.EMPTY;
	}

	public MyInternalErrorException(String code, String message) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public HttpStatus getStatus() {
		return STATUS;
	}

}
