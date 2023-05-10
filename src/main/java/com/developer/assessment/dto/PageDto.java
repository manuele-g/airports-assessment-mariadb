package com.developer.assessment.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * The Class PageDto.
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class PageDto extends SortDto implements Serializable {

	private static final long serialVersionUID = 2509135066108339551L;

	/** The page. */
	@NotNull(message = "Page field must be not blank")
	private Integer page;

	/** The size. */
	@NotNull(message = "Size field must be not blank")
	@Positive(message = "Size field must be positive")
	private Integer size;

	public PageDto(SortDtoBuilder<?, ?> b) {
		super(b);
	}
}
