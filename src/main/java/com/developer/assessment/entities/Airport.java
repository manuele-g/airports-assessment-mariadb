package com.developer.assessment.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the Airports database table.
 * 
 */
@Entity
@Table(name = "Airports")
public class Airport implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1907592485297599992L;

	/** The id. */
	@Id
	private Long id;

	/** The continent. */
	private String continent;

	/** The elevation ft. */
	@Column(name = "elevation_ft")
	private Integer elevationFt;

	/** The gps code. */
	@Column(name = "gps_code")
	private String gpsCode;

	/** The home link. */
	@Column(name = "home_link")
	private String homeLink;

	/** The iata code. */
	@Column(name = "iata_code")
	private String iataCode;

	/** The ident. */
	private String ident;

	/** The iso region. */
	@Column(name = "iso_region")
	private String isoRegion;

	/** The keywords. */
	private String keywords;

	/** The latitude deg. */
	@Column(name = "latitude_deg")
	private Double latitudeDeg;

	/** The local code. */
	@Column(name = "local_code")
	private String localCode;

	/** The longitude deg. */
	@Column(name = "longitude_deg")
	private Double longitudeDeg;

	/** The municipality. */
	private String municipality;

	/** The name. */
	private String name;

	/** The scheduled service. */
	@Column(name = "scheduled_service")
	private String scheduledService;

	/** The type. */
	private String type;

	/** The wikipedia link. */
	@Column(name = "wikipedia_link")
	private String wikipediaLink;

	/** The country. */
	@ManyToOne
	@JoinColumn(name = "iso_country", referencedColumnName = "code")
	private Country country;

	/** The runways. */
	@OneToMany(mappedBy = "airport", fetch = FetchType.LAZY)
	private List<Runway> runways;

	/**
	 * Instantiates a new airport.
	 */
	public Airport() {
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
	 * Gets the elevation ft.
	 *
	 * @return the elevation ft
	 */
	public Integer getElevationFt() {
		return this.elevationFt;
	}

	/**
	 * Sets the elevation ft.
	 *
	 * @param elevationFt the new elevation ft
	 */
	public void setElevationFt(Integer elevationFt) {
		this.elevationFt = elevationFt;
	}

	/**
	 * Gets the gps code.
	 *
	 * @return the gps code
	 */
	public String getGpsCode() {
		return this.gpsCode;
	}

	/**
	 * Sets the gps code.
	 *
	 * @param gpsCode the new gps code
	 */
	public void setGpsCode(String gpsCode) {
		this.gpsCode = gpsCode;
	}

	/**
	 * Gets the home link.
	 *
	 * @return the home link
	 */
	public String getHomeLink() {
		return this.homeLink;
	}

	/**
	 * Sets the home link.
	 *
	 * @param homeLink the new home link
	 */
	public void setHomeLink(String homeLink) {
		this.homeLink = homeLink;
	}

	/**
	 * Gets the iata code.
	 *
	 * @return the iata code
	 */
	public String getIataCode() {
		return this.iataCode;
	}

	/**
	 * Sets the iata code.
	 *
	 * @param iataCode the new iata code
	 */
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	/**
	 * Gets the ident.
	 *
	 * @return the ident
	 */
	public String getIdent() {
		return this.ident;
	}

	/**
	 * Sets the ident.
	 *
	 * @param ident the new ident
	 */
	public void setIdent(String ident) {
		this.ident = ident;
	}

	/**
	 * Gets the iso region.
	 *
	 * @return the iso region
	 */
	public String getIsoRegion() {
		return this.isoRegion;
	}

	/**
	 * Sets the iso region.
	 *
	 * @param isoRegion the new iso region
	 */
	public void setIsoRegion(String isoRegion) {
		this.isoRegion = isoRegion;
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
	 * Gets the latitude deg.
	 *
	 * @return the latitude deg
	 */
	public Double getLatitudeDeg() {
		return this.latitudeDeg;
	}

	/**
	 * Sets the latitude deg.
	 *
	 * @param latitudeDeg the new latitude deg
	 */
	public void setLatitudeDeg(Double latitudeDeg) {
		this.latitudeDeg = latitudeDeg;
	}

	/**
	 * Gets the local code.
	 *
	 * @return the local code
	 */
	public String getLocalCode() {
		return this.localCode;
	}

	/**
	 * Sets the local code.
	 *
	 * @param localCode the new local code
	 */
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	/**
	 * Gets the longitude deg.
	 *
	 * @return the longitude deg
	 */
	public Double getLongitudeDeg() {
		return this.longitudeDeg;
	}

	/**
	 * Sets the longitude deg.
	 *
	 * @param longitudeDeg the new longitude deg
	 */
	public void setLongitudeDeg(Double longitudeDeg) {
		this.longitudeDeg = longitudeDeg;
	}

	/**
	 * Gets the municipality.
	 *
	 * @return the municipality
	 */
	public String getMunicipality() {
		return this.municipality;
	}

	/**
	 * Sets the municipality.
	 *
	 * @param municipality the new municipality
	 */
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
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
	 * Gets the scheduled service.
	 *
	 * @return the scheduled service
	 */
	public String getScheduledService() {
		return this.scheduledService;
	}

	/**
	 * Sets the scheduled service.
	 *
	 * @param scheduledService the new scheduled service
	 */
	public void setScheduledService(String scheduledService) {
		this.scheduledService = scheduledService;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
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
	 * Gets the country.
	 *
	 * @return the country
	 */
	public Country getCountry() {
		return this.country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * Gets the runways.
	 *
	 * @return the runways
	 */
	public List<Runway> getRunways() {
		return this.runways;
	}

	/**
	 * Sets the runways.
	 *
	 * @param runways the new runways
	 */
	public void setRunways(List<Runway> runways) {
		this.runways = runways;
	}

}