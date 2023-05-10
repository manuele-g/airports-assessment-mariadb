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

import com.developer.assessment.dto.AirportDto;
import com.developer.assessment.dto.CountryFilterDto;
import com.developer.assessment.entities.Airport;
import com.developer.assessment.entities.Country;
import com.developer.assessment.entities.Runway;
import com.developer.assessment.mappers.AirportMapper;
import com.developer.assessment.mappers.CountryMapper;
import com.developer.assessment.mappers.RunwayMapper;
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
	CountryMapper countryMapper;

	@Spy
	RunwayMapper runwayMapper;

	@Spy
	private AirportMapper airportMapper;

	@InjectMocks
	private AirportStatisticsService airportStatisticsService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getRunwaysByCountryCodeOrName() {
		CountryFilterDto filter = CountryFilterDto.builder().name("code1").code("name1").page(0).size(10).sortBy("id1")
				.sortOrder("asc1").build();
		List<Airport> airports = createAirports();

		when(this.airportRepository.findByCountryNameOrCodePartialFuzzy(Mockito.anyString(), Mockito.anyString(),
				Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString())).thenReturn(airports);

		List<AirportDto> result = this.airportStatisticsService.getRunwaysByCountryCodeOrName(filter);
		assertNotNull(result);
	}

	@Test
	void getRunwaysByCountryCodeOrName_case_code_is_null() {
		CountryFilterDto filter = CountryFilterDto.builder().name(null).code("name2").page(0).size(10).sortBy("id2")
				.sortOrder("asc2").build();
		List<Airport> airports = createAirports();

		when(this.airportRepository.findByCountryNamePartialFuzzy(Mockito.anyString(), Mockito.anyInt(),
				Mockito.anyInt(), Mockito.anyString())).thenReturn(airports);

		List<AirportDto> result = this.airportStatisticsService.getRunwaysByCountryCodeOrName(filter);
		assertNotNull(result);
	}

	@Test
	void getRunwaysByCountryCodeOrName_case_name_is_null() {
		CountryFilterDto filter = CountryFilterDto.builder().name("code3").code(null).page(0).size(10).sortBy("id3")
				.sortOrder("asc3").build();
		List<Airport> airports = createAirports();
		when(this.airportRepository.findByCountryCodeOrCountryCodeStartsWith(Mockito.anyString(), Mockito.anyString(),
				Mockito.any())).thenReturn(airports);

		List<AirportDto> result = this.airportStatisticsService.getRunwaysByCountryCodeOrName(filter);
		assertNotNull(result);
	}

	@Test
	void getRunwaysByCountryCodeOrName_fail_during_call_repository() {
		CountryFilterDto filter = CountryFilterDto.builder().name(null).code("code4").page(0).size(10).sortBy("id4")
				.sortOrder("asc4").build();

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
