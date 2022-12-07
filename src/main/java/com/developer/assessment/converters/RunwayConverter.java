package com.developer.assessment.converters;

import java.util.List;
import java.util.Optional;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.developer.assessment.dto.RunwayDto;
import com.developer.assessment.entities.Runway;
import com.google.common.collect.Lists;

/**
 * The Class RunwayConverter.
 */
@Converter
@Service
public class RunwayConverter implements AttributeConverter<RunwayDto, Runway> {

	/**
	 * Convert to database column.
	 *
	 * @param dto the dto
	 * @return the runway
	 */
	@Override
	public Runway convertToDatabaseColumn(RunwayDto dto) {
		throw new NotImplementedException();
	}

	/**
	 * Convert to entity attribute.
	 *
	 * @param entity the entity
	 * @return the runway dto
	 */
	@Override
	public RunwayDto convertToEntityAttribute(Runway entity) {
		RunwayDto dto = new RunwayDto();
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
	public List<RunwayDto> convertAllToEntityAttribute(List<Runway> entities) {
		return Optional.ofNullable(entities).orElse(Lists.newArrayList()).stream().map(this::convertToEntityAttribute)
				.toList();
	}
}
