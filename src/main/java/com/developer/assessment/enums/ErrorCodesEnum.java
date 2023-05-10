package com.developer.assessment.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodesEnum {

	E001("Internal Server Error - The server encountered an unexpected condition");

	private String message;
}
