package com.developer.assessment.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.developer.assessment.dto.ExportAirportJsonDto;
import com.developer.assessment.entities.Airport;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExportJsonAirportJsonMapper {

	@Mapping(target = "isoCountry", source = "entity.country.code")
	ExportAirportJsonDto airportToExportJsonAirportJsonDto(Airport entity);

	List<ExportAirportJsonDto> getExportAirports(List<Airport> airportEntities);
}
