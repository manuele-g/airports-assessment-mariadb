package com.developer.assessment.services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.developer.assessment.converters.CountryConverter;
import com.developer.assessment.converters.ExportJsonAirportJsonConverter;
import com.developer.assessment.dto.CountryDto;
import com.developer.assessment.dto.ExportAirportJsonDto;
import com.developer.assessment.entities.Airport;
import com.developer.assessment.entities.Country;
import com.developer.assessment.repositories.AirportRepository;
import com.developer.assessment.repositories.CountryRepository;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

/**
 * The Class ExportService.
 */
@Service
@Transactional
public class ExportService implements IExportService {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(ExportService.class);

	/** The folder to export json. */
	@Value("${export.json.folder}")
	private String folderToExportJson;

	/** The airport repository. */
	@Autowired
	private AirportRepository airportRepository;

	/** The country repository. */
	@Autowired
	private CountryRepository countryRepository;

	/** The export json airport json converter. */
	@Autowired
	private ExportJsonAirportJsonConverter exportJsonAirportJsonConverter;

	/** The country converter. */
	@Autowired
	private CountryConverter countryConverter;

	/**
	 * Export aiport to json data.
	 *
	 * @return the boolean
	 */
	@Override
	public Boolean exportAiportToJsonData() {

		List<ExportAirportJsonDto> airportsToExport = Lists.newArrayList();
		try {
			log.info("Calling database through airport repisitory...");
			List<Airport> airports = this.airportRepository.findAll();
			log.info("Mapping airports from entity to dto...");
			airportsToExport = this.exportJsonAirportJsonConverter.convertAllToEntityAttribute(airports);
			log.info("airports found: {}", airportsToExport.size());
			Gson gson = new Gson();
			log.info("Generating gson...");
			String jsonAirports = gson.toJson(airportsToExport);
			log.info("Exporting gson...");
			return this.exportJson(jsonAirports, "airports");
		} catch (Exception e) {
			log.error("Erorr during exporting airports to json");
			log.error(e.getMessage(), e);
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Export countries to json data.
	 *
	 * @return the boolean
	 */
	@Override
	public Boolean exportCountriesToJsonData() {

		List<CountryDto> countriesToExport = Lists.newArrayList();
		try {
			log.info("Calling database through country repisitory...");
			List<Country> countries = this.countryRepository.findAll();
			log.info("Mapping countries from entity to dto...");
			countriesToExport = this.countryConverter.convertAllToEntityAttribute(countries);
			log.info("countries found: {}", countriesToExport.size());
			log.info("Generating gson...");
			Gson gson = new Gson();
			String jsonCountries = gson.toJson(countriesToExport);
			log.info("Exporting gson...");
			return this.exportJson(jsonCountries, "countries");

		} catch (Exception e) {
			log.error("Erorr during exporting countries to json");
			log.error(e.getMessage(), e);
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Export json.
	 *
	 * @param json     the json
	 * @param nameFile the name file
	 * @return the boolean
	 */
	private Boolean exportJson(String json, String nameFile) {
		Boolean result = Boolean.TRUE;
		StringBuilder path = new StringBuilder(this.folderToExportJson).append("/").append(nameFile).append(".json");
		try (FileWriter file = new FileWriter(path.toString())) {
			log.info("Writing json...");
			file.write(json);
			file.flush();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			result = Boolean.FALSE;
		}
		log.info("End to write and to export data to json.");
		return result;

	}
}
