package com.developer.assessment.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * The Class AirportDto.
 */
@Data
public class AirportDto implements Serializable {

	private static final long serialVersionUID = 381021357337212856L;

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
	private CountryDto country;

	/** The runways. */
	private List<RunwayDto> runways;
}
