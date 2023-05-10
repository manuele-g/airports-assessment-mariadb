package com.developer.assessment.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.developer.assessment.dto.AirportDto;
import com.developer.assessment.entities.Airport;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AirportMapper {

	AirportDto airportToAirportDto(Airport entity);

	List<AirportDto> getAirports(List<Airport> airportEntities);
}
