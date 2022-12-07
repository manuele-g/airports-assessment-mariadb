package com.developer.assessment.converters;

import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.developer.assessment.dto.CountryDto;
import com.developer.assessment.entities.Country;

/**
 * The Class CountryConverter.
 */
@Converter
@Service
public class CountryConverter implements AttributeConverter<CountryDto, Country> {

	/**
	 * Convert to database column.
	 *
	 * @param dto the dto
	 * @return the country
	 */
	@Override
	public Country convertToDatabaseColumn(CountryDto dto) {
		throw new NotImplementedException();
	}

	/**
	 * Convert to entity attribute.
	 *
	 * @param entity the entity
	 * @return the country dto
	 */
	@Override
	public CountryDto convertToEntityAttribute(Country entity) {
		CountryDto dto = new CountryDto();
		if (entity != null) {
			BeanUtils.copyProperties(entity, dto);
		}
		return dto;
	}

	/**
	 * Convert all to entity attribute.
	 *
	 * @param entities the entities
	 * @return the list
	 */
	public List<CountryDto> convertAllToEntityAttribute(List<Country> entities) {
		return entities.stream().map(this::convertToEntityAttribute).toList();
	}
}
