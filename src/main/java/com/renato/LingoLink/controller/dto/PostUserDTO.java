package com.renato.LingoLink.controller.dto;

import java.time.LocalDate;
import java.util.Set;

import com.renato.LingoLink.domain.Language;
import com.renato.LingoLink.domain.UserProfile;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record PostUserDTO(
		@NotEmpty(message = "first name can't be null")
		String firstName,
		@NotEmpty(message = "last name can't be null")
	    String lastName,
	    String bio,
	    String profilePictureUrl,
	    String location,
	    LocalDate dateOfBirth,
	    String nativeLanguageCodeISO6391,
	    Set<String> learningLanguages
	) {}
