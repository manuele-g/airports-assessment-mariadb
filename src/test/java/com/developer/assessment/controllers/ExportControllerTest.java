package com.developer.assessment.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.developer.assessment.DeveloperAssessmentApplication;
import com.developer.assessment.configs.WebSecurityConfig;
import com.developer.assessment.services.IExportService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { DeveloperAssessmentApplication.class, WebSecurityConfig.class })
@WebMvcTest(ExportController.class)
class ExportControllerTest {

	private static final String PATH = "/export";

	@MockBean
	private IExportService exportService;

	@Autowired
	private MockMvc mvc;

	@Test
	void exportAiportToJsonData() throws Exception {

		when(this.exportService.exportAiportToJsonData()).thenReturn(Boolean.TRUE);

		mvc.perform(
				get(PATH + "/airport/json").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void exportCountriesToJsonData() throws Exception {

		when(this.exportService.exportCountriesToJsonData()).thenReturn(Boolean.TRUE);

		mvc.perform(get(PATH + "/countries/json").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
