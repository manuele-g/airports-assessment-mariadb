package com.developer.assessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.developer.assessment.entities.Country;

/**
 * The Interface CountryRepository.
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long>, QuerydslPredicateExecutor<Country> {

}
