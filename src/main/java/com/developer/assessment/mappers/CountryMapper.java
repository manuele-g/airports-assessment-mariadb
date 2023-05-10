package com.developer.assessment.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.developer.assessment.dto.CountryDto;
import com.developer.assessment.entities.Country;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryMapper {

	CountryDto countryToCountryDto(Country entity);

	List<CountryDto> getCountries(List<Country> countryEntities);
}
