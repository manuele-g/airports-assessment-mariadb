package com.developer.assessment.converters;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.developer.assessment.dto.ExportAirportJsonDto;
import com.developer.assessment.entities.Airport;
import com.developer.assessment.entities.Country;
import com.google.common.collect.Lists;

@ExtendWith(SpringExtension.class)
class ExportJsonAirportJsonConverterTest {

	@Spy
	RunwayConverter runwayConverter;

	@InjectMocks
	ExportJsonAirportJsonConverter exportJsonAirportJsonConverter;

	@Test
	void convertToDatabaseColumn() {
		Assertions.assertThrows(NotImplementedException.class, () -> {
			this.exportJsonAirportJsonConverter.convertToDatabaseColumn(null);
		});
	}

	@Test
	void convertAllToEntityAttribute() {
		Airport airport = new Airport();
		airport.setCountry(new Country());
		List<ExportAirportJsonDto> result = this.exportJsonAirportJsonConverter
				.convertAllToEntityAttribute(Lists.newArrayList(airport));
		assertNotNull(result);
	}
}
