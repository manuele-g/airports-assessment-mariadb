package com.developer.assessment.converters;

import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.assessment.dto.ExportAirportJsonDto;
import com.developer.assessment.entities.Airport;

/**
 * The Class ExportJsonAirportJsonConverter.
 */
@Converter
@Service
public class ExportJsonAirportJsonConverter implements AttributeConverter<ExportAirportJsonDto, Airport> {

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
	public Airport convertToDatabaseColumn(ExportAirportJsonDto dto) {
		throw new NotImplementedException();
	}

	/**
	 * Convert to entity attribute.
	 *
	 * @param entity the entity
	 * @return the export airport json dto
	 */
	@Override
	public ExportAirportJsonDto convertToEntityAttribute(Airport entity) {
		ExportAirportJsonDto dto = new ExportAirportJsonDto();
		if (entity != null) {
			BeanUtils.copyProperties(entity, dto);

			dto.setIsoCountry(entity.getCountry().getCode());
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
	public List<ExportAirportJsonDto> convertAllToEntityAttribute(List<Airport> entities) {
		return entities.stream().map(this::convertToEntityAttribute).toList();
	}
}
