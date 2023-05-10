package com.developer.assessment.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * The Class CountryFilterDto.
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class CountryFilterDto extends PageDto implements Serializable {

	private static final long serialVersionUID = -5687098269533875653L;

	/** The code. */
	private String code;

	/** The name. */
	private String name;

	public CountryFilterDto() {
		super(0, 10);
	}

	public CountryFilterDto(SortDtoBuilder<?, ?> b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

}
