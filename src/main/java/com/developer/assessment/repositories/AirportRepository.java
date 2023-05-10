package com.developer.assessment.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.developer.assessment.entities.Airport;

/**
 * The Interface AirportRepository.
 */
@Repository
public interface AirportRepository extends JpaRepository<Airport, Long>, QuerydslPredicateExecutor<Airport> {

	/**
	 * Find by country code ignore case or country name ignore case.
	 *
	 * @param code the code
	 * @param name the name
	 * @return the list
	 */
	List<Airport> findByCountryCodeIgnoreCaseOrCountryNameIgnoreCase(String code, String name);

	/**
	 * Find by country name or code partial fuzzy.
	 *
	 * @param name     the name
	 * @param code     the code
	 * @param rowCount the row count
	 * @param offset   the offset
	 * @param nameLike the name like
	 * @return the list
	 */
	@Query(value = "SELECT * from Airports a1 JOIN Countries c1 ON c1.code = a1.iso_country WHERE (c1.name SOUNDS LIKE(?1) or c1.name LIKE ?5) and c1.code SOUNDS LIKE(?2) ORDER BY a1.id asc LIMIT ?3 OFFSET ?4", nativeQuery = true)
	List<Airport> findByCountryNameOrCodePartialFuzzy(String name, String code, int rowCount, int offset,
			String nameLike);

	/**
	 * Find by country code or country code starts with.
	 *
	 * @param code          the code
	 * @param codeStartWith the code start with
	 * @param pageable      the pageable
	 * @return the list
	 */
	List<Airport> findByCountryCodeOrCountryCodeStartsWith(String code, String codeStartWith, Pageable pageable);

	/**
	 * Find by country name partial fuzzy.
	 *
	 * @param name     the name
	 * @param rowCount the row count
	 * @param offset   the offset
	 * @param nameLike the name like
	 * @return the list
	 */
	@Query(value = "SELECT a1.id, a1.continent,a1.elevation_ft,a1.gps_code,a1.home_link,a1.iata_code,a1.ident,a1.iso_region,a1.keywords,a1.latitude_deg,a1.local_code,a1.longitude_deg,a1.municipality,a1.name,a1.scheduled_service,a1.type,a1.wikipedia_link,a1.iso_country from Airports a1 JOIN Countries c1 ON  c1.code = a1.iso_country WHERE c1.name SOUNDS LIKE(?1) or c1.name LIKE ?4 ORDER BY a1.id asc LIMIT ?2 OFFSET ?3", nativeQuery = true)
	List<Airport> findByCountryNamePartialFuzzy(String name, int rowCount, int offset, String nameLike);
}
