package com.developer.assessment.converters;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.developer.assessment.dto.CountryDto;
import com.developer.assessment.entities.Country;
import com.google.common.collect.Lists;

@ExtendWith(SpringExtension.class)
class CountryConverterTest {

	@InjectMocks
	CountryConverter countryConverter;

	@Test
	void convertToDatabaseColumn() {
		Assertions.assertThrows(NotImplementedException.class, () -> {
			this.countryConverter.convertToDatabaseColumn(null);
		});
	}

	@Test
	void convertAllToEntityAttribute() {
		Country country = new Country();
		List<CountryDto> result = this.countryConverter.convertAllToEntityAttribute(Lists.newArrayList(country));
		assertNotNull(result);
	}
}
