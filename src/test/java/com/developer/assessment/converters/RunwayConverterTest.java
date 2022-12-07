package com.developer.assessment.converters;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunwayConverterTest {

	@InjectMocks
	RunwayConverter runwayConverter;

	@Test
	void convertToDatabaseColumn() {
		Assertions.assertThrows(NotImplementedException.class, () -> {
			this.runwayConverter.convertToDatabaseColumn(null);
		});
	}
}
