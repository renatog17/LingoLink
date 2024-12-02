package com.renato.LingoLink.controller;

import java.time.LocalDate;
import java.util.Set;

import com.renato.LingoLink.domain.Language;

public record PostUserDTO(
	    String firstName,
	    String lastName,
	    String email,
	    String phoneNumber,
	    String bio,
	    String profilePictureUrl,
	    String location,
	    LocalDate dateOfBirth,
	    String nativeLanguageCodeISO6391,
	    Set<String> learningLanguages
	) {}
