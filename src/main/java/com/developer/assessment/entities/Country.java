package com.developer.assessment.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the Countries database table.
 * 
 */
@Entity
@Table(name = "Countries")
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

	/**
	 * Instantiates a new country.
	 */
	public Country() {
		super();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the continent.
	 *
	 * @return the continent
	 */
	public String getContinent() {
		return this.continent;
	}

	/**
	 * Sets the continent.
	 *
	 * @param continent the new continent
	 */
	public void setContinent(String continent) {
		this.continent = continent;
	}

	/**
	 * Gets the keywords.
	 *
	 * @return the keywords
	 */
	public String getKeywords() {
		return this.keywords;
	}

	/**
	 * Sets the keywords.
	 *
	 * @param keywords the new keywords
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the wikipedia link.
	 *
	 * @return the wikipedia link
	 */
	public String getWikipediaLink() {
		return this.wikipediaLink;
	}

	/**
	 * Sets the wikipedia link.
	 *
	 * @param wikipediaLink the new wikipedia link
	 */
	public void setWikipediaLink(String wikipediaLink) {
		this.wikipediaLink = wikipediaLink;
	}

	/**
	 * Gets the airports.
	 *
	 * @return the airports
	 */
	public List<Airport> getAirports() {
		return this.airports;
	}

	/**
	 * Sets the airports.
	 *
	 * @param airports the new airports
	 */
	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}

}