package com.developer.assessment.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;

import com.developer.assessment.converters.AirportConverter;
import com.developer.assessment.converters.CountryConverter;
import com.developer.assessment.converters.RunwayConverter;
import com.developer.assessment.dto.AirportDto;
import com.developer.assessment.dto.CountryFilterDto;
import com.developer.assessment.entities.Airport;
import com.developer.assessment.entities.Country;
import com.developer.assessment.entities.Runway;
import com.developer.assessment.repositories.AirportRepository;
import com.developer.assessment.repositories.CountryRepository;
import com.google.common.collect.Lists;

@ExtendWith(SpringExtension.class)
class AirportStatisticsServiceTest {

	@Mock
	private AirportRepository airportRepository;

	@Mock
	private CountryRepository countryRepository;

	@Spy
	CountryConverter countryConverter;

	@Spy
	RunwayConverter runwayConverter;

	@Spy
	@InjectMocks
	private AirportConverter airportConverter;

	@InjectMocks
	private AirportStatisticsService airportStatisticsService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getRunwaysByCountryCodeOrName() {

		CountryFilterDto filter = new CountryFilterDto("code1", "name1", 0, 10, "id1", "asc1");
		List<Airport> airports = createAirports();

		when(this.airportRepository.findByCountryNameOrCodePartialFuzzy(Mockito.anyString(), Mockito.anyString(),
				Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString())).thenReturn(airports);

		List<AirportDto> result = this.airportStatisticsService.getRunwaysByCountryCodeOrName(filter);
		assertNotNull(result);
	}

	@Test
	void getRunwaysByCountryCodeOrName_case_code_is_null() {

		CountryFilterDto filter = new CountryFilterDto(null, "name2", 0, 10, "id2", "asc2");
		List<Airport> airports = createAirports();

		when(this.airportRepository.findByCountryNamePartialFuzzy(Mockito.anyString(), Mockito.anyInt(),
				Mockito.anyInt(), Mockito.anyString())).thenReturn(airports);

		List<AirportDto> result = this.airportStatisticsService.getRunwaysByCountryCodeOrName(filter);
		assertNotNull(result);
	}

	@Test
	void getRunwaysByCountryCodeOrName_case_name_is_null() {

		CountryFilterDto filter = new CountryFilterDto("code3", null, 0, 10, "id3", "asc3");
		List<Airport> airports = createAirports();
		when(this.airportRepository.findByCountryCodeOrCountryCodeStartsWith(Mockito.anyString(), Mockito.anyString(),
				Mockito.any())).thenReturn(airports);

		List<AirportDto> result = this.airportStatisticsService.getRunwaysByCountryCodeOrName(filter);
		assertNotNull(result);
	}

	@Test
	void getRunwaysByCountryCodeOrName_fail_during_call_repository() {

		CountryFilterDto filter = new CountryFilterDto("code4", null, 0, 10, "id4", "asc4");

		when(this.airportRepository.findByCountryCodeOrCountryCodeStartsWith(Mockito.anyString(), Mockito.anyString(),
				Mockito.any())).thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));

		Assertions.assertThrows(HttpClientErrorException.class, () -> {
			this.airportStatisticsService.getRunwaysByCountryCodeOrName(filter);
		});
	}

	private static final List<Airport> createAirports() {
		Airport airport = new Airport();
		airport.setName("nameAirport");
		airport.setCountry(new Country());
		airport.setRunways(Lists.newArrayList(new Runway()));
		return Lists.newArrayList(airport);
	}
}
