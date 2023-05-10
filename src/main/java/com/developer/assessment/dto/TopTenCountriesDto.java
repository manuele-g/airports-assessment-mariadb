package com.developer.assessment.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * The Class TopTenCountriesDto.
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class TopTenCountriesDto extends CountryDto implements Serializable {

	private static final long serialVersionUID = -8526483357642980288L;

	/** The number of airports. */
	private Integer numberOfAirports;

	public TopTenCountriesDto() {
		super();
	}

}
