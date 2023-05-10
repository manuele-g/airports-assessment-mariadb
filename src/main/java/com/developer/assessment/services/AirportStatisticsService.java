package com.developer.assessment.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.developer.assessment.dto.AirportDto;
import com.developer.assessment.dto.CountryFilterDto;
import com.developer.assessment.dto.TopTenCountriesDto;
import com.developer.assessment.entities.Airport;
import com.developer.assessment.entities.Country;
import com.developer.assessment.entities.QCountry;
import com.developer.assessment.mappers.AirportMapper;
import com.developer.assessment.repositories.AirportRepository;
import com.google.common.collect.Lists;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * The Class AiportStatisticsService.
 */
@Service
@Transactional
public class AirportStatisticsService implements IAirportStatisticsService {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AirportStatisticsService.class);

	/** The Constant INTERNAL_ERROR. */
	private static final String INTERNAL_ERROR = "Internal Error";

	/** The airport repository. */
	@Autowired
	private AirportRepository airportRepository;

	/** The airport converter. */
	@Autowired
	private AirportMapper airportMapper;

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/** The country jpa query. */
	JPAQuery<Country> countryJpaQuery;

	/**
	 * Gets the runways by country code or name.
	 *
	 * @param filter the filter
	 * @return the runways by country code or name
	 */
	@Override
	public List<AirportDto> getRunwaysByCountryCodeOrName(CountryFilterDto filter) {
		try {
			List<Airport> airports = Lists.newArrayList();
			Pageable pageable = PageRequest.of(filter.getPage(), filter.getSize(), Sort.by("id").ascending());
			int offset = filter.getSize() * filter.getPage();

			if (StringUtils.isNotBlank(filter.getName()) && StringUtils.isNotBlank(filter.getCode())) {

				log.info("Name and Code aren't blank. Calling database through repisitory.");
				airports = this.airportRepository.findByCountryNameOrCodePartialFuzzy(filter.getName(),
						filter.getCode(), filter.getSize(), offset,
						new StringBuilder(filter.getName()).append("%").toString());

			} else if (StringUtils.isNotBlank(filter.getName())) {

				log.info("Name isn't blank and Code is null or blank. Calling database through repisitory.");
				airports = this.airportRepository.findByCountryNamePartialFuzzy(filter.getName(), filter.getSize(),
						offset, new StringBuilder(filter.getName()).append("%").toString());

			} else if (StringUtils.isNotBlank(filter.getCode())) {

				log.info("Code isn't blank and Name is null or blank. Calling database through repisitory.");
				airports = this.airportRepository.findByCountryCodeOrCountryCodeStartsWith(filter.getCode(),
						filter.getCode(), pageable);
			}

			log.info("Mapping airports from entity to dto");
			return this.airportMapper.getAirports(airports);
		} catch (Exception e) {
			log.error("Erorr during exporting airports to json");
			log.error(e.getMessage(), e);
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Gets the top ten countries.
	 *
	 * @param limit the limit
	 * @return the top ten countries
	 */
	@Override
	public List<TopTenCountriesDto> getTopCountries(int limit) {
		try {
			log.info("Building query to get top ten countries with more airports");
			JPAQuery<Country> jpaQuery = new JPAQuery<>(entityManager);
			JPAQuery<Tuple> baseQuery = jpaQuery
					.select(QCountry.country.id, QCountry.country.code, QCountry.country.name,
							QCountry.country.continent, QCountry.country.wikipediaLink,
							QCountry.country.airports.size())
					.from(QCountry.country).orderBy(QCountry.country.airports.size().desc()).limit(limit);
			List<Tuple> countries = baseQuery.fetch();
			log.info("Mapping countries from entity to dto");
			return countries.stream().map(AirportStatisticsService::extractedColumn).toList();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new InternalError(INTERNAL_ERROR);
		}
	}

	/**
	 * Extracted column.
	 *
	 * @param t the t
	 * @return the top ten countries dto
	 */
	private static final TopTenCountriesDto extractedColumn(Tuple t) {
		TopTenCountriesDto result = new TopTenCountriesDto();
		result.setId(t.get(0, Long.class));
		result.setCode(t.get(1, String.class));
		result.setName(t.get(2, String.class));
		result.setContinent(t.get(3, String.class));
		result.setWikipediaLink(t.get(4, String.class));
		result.setNumberOfAirports(t.get(5, Integer.class));
		return result;

	}
}
