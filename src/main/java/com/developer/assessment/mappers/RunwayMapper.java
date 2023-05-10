package com.developer.assessment.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.developer.assessment.dto.RunwayDto;
import com.developer.assessment.entities.Runway;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RunwayMapper {

	RunwayDto runwayToRunwayDto(Runway entity);

	@Mapping(target = "airport", ignore = true)
	Runway runwayDtoToRunway(RunwayDto dto);
}
