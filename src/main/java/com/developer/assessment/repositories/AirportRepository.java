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
	@Query(value = "SELECT * from Airports a JOIN Countries c ON c.code = a.iso_country WHERE (c.name SOUNDS LIKE(?1) or c.name LIKE ?5) and c.code SOUNDS LIKE(?2) ORDER BY a.id asc LIMIT ?3 OFFSET ?4", nativeQuery = true)
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
	@Query(value = "SELECT * from Airports a JOIN Countries c ON  c.code = a.iso_country WHERE c.name SOUNDS LIKE(?1) or c.name LIKE ?4 ORDER BY a.id asc LIMIT ?2 OFFSET ?3", nativeQuery = true)
	List<Airport> findByCountryNamePartialFuzzy(String name, int rowCount, int offset, String nameLike);
}
