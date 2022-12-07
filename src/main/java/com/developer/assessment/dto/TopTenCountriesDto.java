package com.developer.assessment.dto;

/**
 * The Class TopTenCountriesDto.
 */
public class TopTenCountriesDto extends CountryDto {

	/** The number of airports. */
	private Integer numberOfAirports;

	/**
	 * Instantiates a new top ten countries dto.
	 */
	public TopTenCountriesDto() {
		super();
	}

	/**
	 * Gets the number of airports.
	 *
	 * @return the number of airports
	 */
	public Integer getNumberOfAirports() {
		return numberOfAirports;
	}

	/**
	 * Sets the number of airports.
	 *
	 * @param numberOfAirports the new number of airports
	 */
	public void setNumberOfAirports(Integer numberOfAirports) {
		this.numberOfAirports = numberOfAirports;
	}

}
