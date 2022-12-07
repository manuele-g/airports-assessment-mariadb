package com.developer.assessment.dto;

import java.util.List;

/**
 * The Class ExportAirportJsonDto.
 */
public class ExportAirportJsonDto {

	/** The id. */
	private Long id;

	/** The continent. */
	private String continent;

	/** The elevation ft. */
	private Integer elevationFt;

	/** The gps code. */
	private String gpsCode;

	/** The home link. */
	private String homeLink;

	/** The iata code. */
	private String iataCode;

	/** The ident. */
	private String ident;

	/** The iso region. */
	private String isoRegion;

	/** The keywords. */
	private String keywords;

	/** The latitude deg. */
	private Double latitudeDeg;

	/** The local code. */
	private String localCode;

	/** The longitude deg. */
	private Double longitudeDeg;

	/** The municipality. */
	private String municipality;

	/** The name. */
	private String name;

	/** The scheduled service. */
	private String scheduledService;

	/** The type. */
	private String type;

	/** The wikipedia link. */
	private String wikipediaLink;

	/** The country. */
	private String isoCountry;

	/** The runways. */
	private List<RunwayDto> runways;

	/**
	 * Instantiates a new export airport json dto.
	 */
	public ExportAirportJsonDto() {
		super();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
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
		return continent;
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
		return elevationFt;
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
		return gpsCode;
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
		return homeLink;
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
		return iataCode;
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
		return ident;
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
		return isoRegion;
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
		return keywords;
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
		return latitudeDeg;
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
		return localCode;
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
		return longitudeDeg;
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
		return municipality;
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
		return name;
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
		return scheduledService;
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
		return type;
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
		return wikipediaLink;
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
	 * Gets the iso country.
	 *
	 * @return the iso country
	 */
	public String getIsoCountry() {
		return isoCountry;
	}

	/**
	 * Sets the iso country.
	 *
	 * @param isoCountry the new iso country
	 */
	public void setIsoCountry(String isoCountry) {
		this.isoCountry = isoCountry;
	}

	/**
	 * Gets the runways.
	 *
	 * @return the runways
	 */
	public List<RunwayDto> getRunways() {
		return runways;
	}

	/**
	 * Sets the runways.
	 *
	 * @param runways the new runways
	 */
	public void setRunways(List<RunwayDto> runways) {
		this.runways = runways;
	}
}
