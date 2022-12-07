package com.developer.assessment.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.developer.assessment.DeveloperAssessmentApplication;
import com.developer.assessment.configs.WebSecurityConfig;
import com.developer.assessment.dto.CountryFilterDto;
import com.developer.assessment.services.IAirportStatisticsService;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { DeveloperAssessmentApplication.class, WebSecurityConfig.class })
@WebMvcTest(AirportStatisticsController.class)
class AirportStatisticsControllerTest {

	private static final String PATH = "/airport/statistics";

	@MockBean
	private IAirportStatisticsService airportStatisticsService;

	@Autowired
	private MockMvc mvc;

	@Test
	void getTopCountries() throws Exception {

		when(this.airportStatisticsService.getTopCountries(Mockito.anyInt())).thenReturn(Lists.newArrayList());

		mvc.perform(get(PATH + "/top/10/countries").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void getTopCountries_fail_input_wrong() throws Exception {

		mvc.perform(get(PATH + "/top/null/countries").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	void getRunwaysByCountryCodeOrName() throws Exception {

		CountryFilterDto filter = new CountryFilterDto(StringUtils.EMPTY, StringUtils.EMPTY, 0, 10, "id3", "asc1");

		when(this.airportStatisticsService.getRunwaysByCountryCodeOrName(Mockito.any(CountryFilterDto.class)))
				.thenReturn(Lists.newArrayList());

		mvc.perform(post(PATH + "/given/country").content(new Gson().toJson(filter)).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void getRunwaysByCountryCodeOrName_fail_size_negative() throws Exception {

		CountryFilterDto filter = new CountryFilterDto(StringUtils.EMPTY, StringUtils.EMPTY, 0, -1, "id2", "asc2");

		mvc.perform(post(PATH + "/given/country").content(new Gson().toJson(filter)).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	void getRunwaysByCountryCodeOrName_fail_sortBy_null() throws Exception {

		CountryFilterDto filter = new CountryFilterDto(StringUtils.EMPTY, StringUtils.EMPTY, 0, 10, null, "asc3");

		mvc.perform(post(PATH + "/given/country").content(new Gson().toJson(filter)).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	void getRunwaysByCountryCodeOrName_fail_sortBy_blank() throws Exception {

		CountryFilterDto filter = new CountryFilterDto(StringUtils.EMPTY, StringUtils.EMPTY, 0, 10, StringUtils.EMPTY,
				"asc3");

		mvc.perform(post(PATH + "/given/country").content(new Gson().toJson(filter)).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	void getRunwaysByCountryCodeOrName_fail_sortOrder_null() throws Exception {

		CountryFilterDto filter = new CountryFilterDto(StringUtils.EMPTY, StringUtils.EMPTY, 0, 10, "id1", null);

		mvc.perform(post(PATH + "/given/country").content(new Gson().toJson(filter)).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	void getRunwaysByCountryCodeOrName_fail_sortOrder_blank() throws Exception {

		CountryFilterDto filter = new CountryFilterDto(StringUtils.EMPTY, StringUtils.EMPTY, 0, 10, "id",
				StringUtils.EMPTY);

		mvc.perform(post(PATH + "/given/country").content(new Gson().toJson(filter)).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}
}
