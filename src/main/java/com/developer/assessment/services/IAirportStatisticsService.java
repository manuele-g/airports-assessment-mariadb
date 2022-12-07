package com.developer.assessment.services;

import java.util.List;

import com.developer.assessment.dto.AirportDto;
import com.developer.assessment.dto.CountryFilterDto;
import com.developer.assessment.dto.TopTenCountriesDto;

/**
 * The Interface IAirportStatisticsService.
 */
public interface IAirportStatisticsService {

	/**
	 * Gets the runways by country code or name.
	 *
	 * @param filter the filter
	 * @return the runways by country code or name
	 */
	List<AirportDto> getRunwaysByCountryCodeOrName(CountryFilterDto filter);

	/**
	 * Gets the top ten countries.
	 *
	 * @param limit the limit
	 * @return the top ten countries
	 */
	List<TopTenCountriesDto> getTopCountries(int limit);

}
