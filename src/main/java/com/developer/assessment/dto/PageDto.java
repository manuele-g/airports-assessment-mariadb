package com.developer.assessment.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * The Class PageDto.
 */
public class PageDto extends SortDto {

	/** The page. */
	@NotNull(message = "Page field must be not blank")
	private Integer page;

	/** The size. */
	@NotNull(message = "Size field must be not blank")
	@Positive(message = "Size field must be positive")
	private Integer size;

	/**
	 * Instantiates a new page dto.
	 */
	public PageDto() {
		super();
	}

	/**
	 * Instantiates a new page dto.
	 *
	 * @param page the page
	 * @param size the size
	 */
	public PageDto(@NotNull Integer page, @NotNull @Positive Integer size) {
		super();
		this.page = page;
		this.size = size;
	}

	/**
	 * Instantiates a new page dto.
	 *
	 * @param page the page
	 * @param size the size
	 * @param sortBy the sort by
	 * @param sortOrder the sort order
	 */
	public PageDto(@NotNull Integer page, @NotNull @Positive Integer size, @NotBlank String sortBy,
			@NotBlank String sortOrder) {
		super(sortBy, sortOrder);
		this.page = page;
		this.size = size;
	}

	/**
	 * Gets the page.
	 *
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * Sets the page.
	 *
	 * @param page the new page
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}
}
