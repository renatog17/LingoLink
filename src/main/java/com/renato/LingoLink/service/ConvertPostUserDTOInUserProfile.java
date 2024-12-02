package com.renato.LingoLink.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.LingoLink.controller.PostUserDTO;
import com.renato.LingoLink.domain.Language;
import com.renato.LingoLink.domain.UserProfile;
import com.renato.LingoLink.repository.LanguageRepository;

@Service
public class ConvertPostUserDTOInUserProfile {

	@Autowired
	LanguageRepository languageRepository;

	public void convertPostUserDTOInUserProfile(UserProfile userProfile, PostUserDTO postUserDTO) {
		Language nativeLanguage;
		try {
			nativeLanguage = languageRepository.findById(postUserDTO.nativeLanguageCodeISO6391().toUpperCase()).get();
		} catch (Exception e) {
			nativeLanguage = languageRepository.findById("EN").get();
		}
		
		Set<String> upperCasedLanguages = postUserDTO.learningLanguages()
	            .stream()
				.map(String::toUpperCase) // Converte cada String para maiúsculas
				.collect(Collectors.toSet());
		Set<Language> learningLanguages = languageRepository.findByCodeIn(upperCasedLanguages);

		userProfile.setBio(postUserDTO.bio());
		userProfile.setDateOfBirth(postUserDTO.dateOfBirth());
		userProfile.setFirstName(postUserDTO.firstName());
		userProfile.setLastName(postUserDTO.lastName());
		userProfile.setLearningLanguages(learningLanguages);
		userProfile.setLocation(postUserDTO.location());
		userProfile.setNativeLanguage(nativeLanguage);
		userProfile.setProfilePictureUrl(postUserDTO.profilePictureUrl());
	}
}
