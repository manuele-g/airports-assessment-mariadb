package com.developer.assessment.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * The Class CountryFilterDto.
 */
public class CountryFilterDto extends PageDto {

	/** The code. */
	private String code;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new country filter dto.
	 */
	public CountryFilterDto() {
		super();
	}

	/**
	 * Instantiates a new country filter dto.
	 *
	 * @param code the code
	 * @param name the name
	 * @param page the page
	 * @param size the size
	 * @param sortBy the sort by
	 * @param sortOrder the sort order
	 */
	public CountryFilterDto(String code, String name, @NotNull Integer page, @NotNull @Positive Integer size,
			@NotBlank String sortBy, @NotBlank String sortOrder) {
		super(page, size, sortBy, sortOrder);
		this.code = code;
		this.name = name;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
