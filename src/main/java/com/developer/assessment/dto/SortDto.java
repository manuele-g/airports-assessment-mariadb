package com.developer.assessment.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * The Class SortDto.
 */
@Data
@SuperBuilder
public class SortDto implements Serializable {

	private static final long serialVersionUID = -5796354683445546329L;

	/** The sort by. */
	@NotBlank(message = "Sort by must be not blank")
	private String sortBy;

	/** The sort order. */
	@NotBlank(message = "Sort order must be not blank")
	private String sortOrder;

	public SortDto() {
		super();
	}
}
