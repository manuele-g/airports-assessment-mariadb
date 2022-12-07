package com.developer.assessment.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.assessment.dto.AirportDto;
import com.developer.assessment.dto.CountryFilterDto;
import com.developer.assessment.dto.TopTenCountriesDto;
import com.developer.assessment.services.IAirportStatisticsService;

/**
 * The Class AirportStatisticsController.
 */
@RestController
@RequestMapping("/airport/statistics")
public class AirportStatisticsController {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AirportStatisticsController.class);

	/** The airport statistics service. */
	@Autowired
	private IAirportStatisticsService airportStatisticsService;

	/**
	 * Gets the runways by country code or name.
	 *
	 * @param filter the filter
	 * @return the runways by country code or name
	 */
	@PostMapping("/given/country")
	public List<AirportDto> getRunwaysByCountryCodeOrName(@Validated @RequestBody CountryFilterDto filter) {
		log.info("Start getting runways given a country code or name");
		return this.airportStatisticsService.getRunwaysByCountryCodeOrName(filter);
	}

	/**
	 * Gets the top ten countries.
	 *
	 * @param limit the limit
	 * @return the top ten countries
	 */
	@GetMapping("/top/{limit}/countries")
	public List<TopTenCountriesDto> getTopCountries(@PathVariable(required = true) int limit) {
		log.info("Start getting top {} countries with highest number of airports.", limit);
		return this.airportStatisticsService.getTopCountries(limit);
	}
}
