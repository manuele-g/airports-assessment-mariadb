package com.developer.assessment.converters;

import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.assessment.dto.AirportDto;
import com.developer.assessment.entities.Airport;

/**
 * The Class AirportConverter.
 */
@Converter
@Service
public class AirportConverter implements AttributeConverter<AirportDto, Airport> {

	/** The country converter. */
	@Autowired
	CountryConverter countryConverter;

	/** The runway converter. */
	@Autowired
	RunwayConverter runwayConverter;

	/**
	 * Convert to database column.
	 *
	 * @param dto the dto
	 * @return the airport
	 */
	@Override
	public Airport convertToDatabaseColumn(AirportDto dto) {
		throw new NotImplementedException();
	}

	/**
	 * Convert to entity attribute.
	 *
	 * @param entity the entity
	 * @return the airport dto
	 */
	@Override
	public AirportDto convertToEntityAttribute(Airport entity) {
		AirportDto dto = new AirportDto();
		if (entity != null) {
			BeanUtils.copyProperties(entity, dto);

			dto.setCountry(this.countryConverter.convertToEntityAttribute(entity.getCountry()));
			dto.setRunways(this.runwayConverter.convertAllToEntityAttribute(entity.getRunways()));
		}
		return dto;
	}

	/**
	 * Convert all to entity attribute.
	 *
	 * @param entities the entities
	 * @return the list
	 */
	public List<AirportDto> convertAllToEntityAttribute(List<Airport> entities) {
		return entities.stream().map(this::convertToEntityAttribute).toList();
	}
}
