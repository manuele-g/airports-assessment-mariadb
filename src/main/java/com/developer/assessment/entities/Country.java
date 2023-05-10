package com.developer.assessment.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The persistent class for the Countries database table.
 * 
 */
@Entity
@Table(name = "Countries")
@Data
public class Country implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1601450902842938728L;

	/** The id. */
	@Id
	private Long id;

	/** The code. */
	private String code;

	/** The continent. */
	private String continent;

	/** The keywords. */
	private String keywords;

	/** The name. */
	private String name;

	/** The wikipedia link. */
	@Column(name = "wikipedia_link")
	private String wikipediaLink;

	/** The airports. */
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	private List<Airport> airports;
}