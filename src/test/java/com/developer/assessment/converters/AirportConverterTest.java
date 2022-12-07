package com.developer.assessment.converters;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class AirportConverterTest {

	@Spy
	CountryConverter countryConverter;

	@Spy
	RunwayConverter runwayConverter;

	@InjectMocks
	private AirportConverter airportConverter;

	@Test
	void convertToDatabaseColumn() {
		Assertions.assertThrows(NotImplementedException.class, () -> {
			this.airportConverter.convertToDatabaseColumn(null);
		});
	}
}
