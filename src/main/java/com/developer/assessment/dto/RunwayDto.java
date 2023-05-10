package com.developer.assessment.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * The Class RunwayDto.
 */
@Data
public class RunwayDto implements Serializable {

	private static final long serialVersionUID = -8778931529267474919L;

	/** The id. */
	private Long id;

	/** The airport ident. */
	private String airportIdent;

	/** The closed. */
	private Boolean closed;

	/** The he displaced threshold ft. */
	private Integer heDisplacedThresholdFt;

	/** The he elevation ft. */
	private Integer heElevationFt;

	/** The he heading deg T. */
	private Integer heHeadingDegT;

	/** The he ident. */
	private String heIdent;

	/** The he latitude deg. */
	private Double heLatitudeDeg;

	/** The he longitude deg. */
	private Double heLongitudeDeg;

	/** The le displaced threshold ft. */
	private Integer leDisplacedThresholdFt;

	/** The le elevation ft. */
	private Integer leElevationFt;

	/** The le heading deg T. */
	private Integer leHeadingDegT;

	/** The le ident. */
	private String leIdent;

	/** The le latitude deg. */
	private Double leLatitudeDeg;

	/** The le longitude deg. */
	private Double leLongitudeDeg;

	/** The length ft. */
	private Integer lengthFt;

	/** The lighted. */
	private Boolean lighted;

	/** The surface. */
	private String surface;

	/** The width ft. */
	private Integer widthFt;

}
