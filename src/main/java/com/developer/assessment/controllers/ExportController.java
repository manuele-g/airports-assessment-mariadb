package com.developer.assessment.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.assessment.services.IExportService;

/**
 * The Class ExportController.
 */
@RestController
@RequestMapping("/export")
public class ExportController {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(ExportController.class);

	/** The export service. */
	@Autowired
	private IExportService exportService;

	/**
	 * Export aiport to json data.
	 *
	 * @return the boolean
	 */
	@GetMapping("/airport/json")
	public Boolean exportAiportToJsonData() {
		log.info("Start to export airports to json");
		return this.exportService.exportAiportToJsonData();
	}

	/**
	 * Export countries to json data.
	 *
	 * @return the boolean
	 */
	@GetMapping("/countries/json")
	public Boolean exportCountriesToJsonData() {
		log.info("Start to export contries to json");
		return this.exportService.exportCountriesToJsonData();
	}
}
