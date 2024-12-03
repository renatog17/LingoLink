package com.renato.LingoLink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.LingoLink.controller.dto.PostUserDTO;
import com.renato.LingoLink.domain.UserProfile;
import com.renato.LingoLink.repository.UserProfileRepository;

import jakarta.validation.Valid;

@Service
public class UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepository;
	@Autowired
	private ConvertPostUserDTOInUserProfile convertPostUserDTOInUserProfile;
	
	public UserProfile createNewUserProfile(@Valid PostUserDTO postUserDTO) {
		UserProfile userProfile = new UserProfile();
		convertPostUserDTOInUserProfile.convertPostUserDTOInUserProfile(userProfile, postUserDTO);
		
		return userProfileRepository.save(userProfile);		
	}
}
