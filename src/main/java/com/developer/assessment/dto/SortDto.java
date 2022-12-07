package com.developer.assessment.dto;

import javax.validation.constraints.NotBlank;

/**
 * The Class SortDto.
 */
public class SortDto {

	/** The sort by. */
	@NotBlank(message = "Sort by must be not blank")
	private String sortBy;

	/** The sort order. */
	@NotBlank(message = "Sort order must be not blank")
	private String sortOrder;

	/**
	 * Instantiates a new sort dto.
	 */
	public SortDto() {
		super();
	}

	/**
	 * Instantiates a new sort dto.
	 *
	 * @param sortBy the sort by
	 * @param sortOrder the sort order
	 */
	public SortDto(@NotBlank String sortBy, @NotBlank String sortOrder) {
		super();
		this.sortBy = sortBy;
		this.sortOrder = sortOrder;
	}

	/**
	 * Gets the sort by.
	 *
	 * @return the sort by
	 */
	public String getSortBy() {
		return sortBy;
	}

	/**
	 * Sets the sort by.
	 *
	 * @param sortBy the new sort by
	 */
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	/**
	 * Gets the sort order.
	 *
	 * @return the sort order
	 */
	public String getSortOrder() {
		return sortOrder;
	}

	/**
	 * Sets the sort order.
	 *
	 * @param sortOrder the new sort order
	 */
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

}
