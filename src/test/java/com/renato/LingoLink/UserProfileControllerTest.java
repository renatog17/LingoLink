package com.renato.LingoLink;

import java.time.LocalDate;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.renato.LingoLink.controller.dto.PostUserDTO;

import jakarta.transaction.Transactional;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserProfileControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	@DisplayName("should return sucess")
	public void postUserProfile_Success() throws JsonProcessingException, Exception {
		//arrange
		PostUserDTO postUserDTO = PostUserDTO.builder()
	            .firstName("Renato")
	            .lastName("Silva")
	            .bio("Software Engineer")
	            .profilePictureUrl("https://example.com/profile.jpg")
	            .location("Monte Gordo, BA, Brazil")
	            .dateOfBirth(LocalDate.of(1999, 5, 15))
	            .nativeLanguageCodeISO6391("PT")
	            .learningLanguages(Set.of("EN", "ES", "RU")) // Definindo um conjunto de idiomas
	            .build();
		//act
		mockMvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(postUserDTO)))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	@DisplayName("should return validation errors")
	public void postUserProfile_ValidationsErrors() throws JsonProcessingException, Exception {
		//arrange
		PostUserDTO postUserDTO = PostUserDTO.builder()
				.firstName(null)
				.lastName(null)
				.build();
		//act && assert
		mockMvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(postUserDTO)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.jsonPath("$[?(@.campo == 'firstName')].mensagem").value("first name can't be null"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[?(@.campo == 'lastName')].mensagem").value("last name can't be null"));
	}
	//validation erros
	//
}
