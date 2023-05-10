package com.developer.assessment.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The persistent class for the Runways database table.
 * 
 */
@Entity
@Table(name = "Runways")
@Data
public class Runway implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 587018188284792878L;

	/** The id. */
	@Id
	private Long id;

	/** The airport ident. */
	@Column(name = "airport_ident")
	private String airportIdent;

	/** The closed. */
	private Boolean closed;

	/** The he displaced threshold ft. */
	@Column(name = "he_displaced_threshold_ft")
	private Integer heDisplacedThresholdFt;

	/** The he elevation ft. */
	@Column(name = "he_elevation_ft")
	private Integer heElevationFt;

	/** The he heading deg T. */
	@Column(name = "he_heading_degT")
	private Integer heHeadingDegT;

	/** The he ident. */
	@Column(name = "he_ident")
	private String heIdent;

	/** The he latitude deg. */
	@Column(name = "he_latitude_deg")
	private Double heLatitudeDeg;

	/** The he longitude deg. */
	@Column(name = "he_longitude_deg")
	private Double heLongitudeDeg;

	/** The le displaced threshold ft. */
	@Column(name = "le_displaced_threshold_ft")
	private Integer leDisplacedThresholdFt;

	/** The le elevation ft. */
	@Column(name = "le_elevation_ft")
	private Integer leElevationFt;

	/** The le heading deg T. */
	@Column(name = "le_heading_degT")
	private Integer leHeadingDegT;

	/** The le ident. */
	@Column(name = "le_ident")
	private String leIdent;

	/** The le latitude deg. */
	@Column(name = "le_latitude_deg")
	private Double leLatitudeDeg;

	/** The le longitude deg. */
	@Column(name = "le_longitude_deg")
	private Double leLongitudeDeg;

	/** The length ft. */
	@Column(name = "length_ft")
	private Integer lengthFt;

	/** The lighted. */
	private Boolean lighted;

	/** The surface. */
	private String surface;

	/** The width ft. */
	@Column(name = "width_ft")
	private Integer widthFt;

	/** The airport. */
	@ManyToOne
	@JoinColumn(name = "airport_ref")
	private Airport airport;
}