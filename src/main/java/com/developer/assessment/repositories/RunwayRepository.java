package com.developer.assessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.developer.assessment.entities.Runway;

/**
 * The Interface RunwayRepository.
 */
@Repository
public interface RunwayRepository extends JpaRepository<Runway, Long>, QuerydslPredicateExecutor<Runway> {

}
