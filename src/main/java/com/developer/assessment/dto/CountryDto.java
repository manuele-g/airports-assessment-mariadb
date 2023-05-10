package com.developer.assessment.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * The Class CountryDto.
 */
@Data
@SuperBuilder
public class CountryDto implements Serializable {

	private static final long serialVersionUID = 5735158635788260115L;

	/** The id. */
	private Long id;

	/** The code. */
	private String code;

	/** The continent. */
	private String continent;

	/** The keywords. */
	private String keywords;

	/** The name. */
	private String name;

	/** The wikipedia link. */
	private String wikipediaLink;

	public CountryDto() {
		super();
	}
}
