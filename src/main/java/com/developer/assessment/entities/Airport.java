package com.developer.assessment.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The persistent class for the Airports database table.
 * 
 */
@Entity
@Table(name = "Airports")
@Data
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

}