package com.renato.LingoLink.controller.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.renato.LingoLink.domain.Language;
import com.renato.LingoLink.domain.UserProfile;

public record ReadUserDTO(
		String firstName,
	    String lastName,
	    String bio,
	    String profilePictureUrl,
	    String location,
	    LocalDate dateOfBirth,
	    String nativeLanguageCodeISO6391,
	    Set<String> learningLanguages) {
	
	public ReadUserDTO(UserProfile userProfile) {
		
		this(userProfile.getFirstName(),
				userProfile.getLastName(),
				userProfile.getBio(),
				userProfile.getProfilePictureUrl(),
				userProfile.getLocation(),
				userProfile.getDateOfBirth(),
				userProfile.getNativeLanguage().getCode(),
				
				userProfile.getLearningLanguages().stream()
				.map(Language::getCode)
				.collect(Collectors.toSet())
				
				);
	}
}
