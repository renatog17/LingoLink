package com.renato.LingoLink.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.renato.LingoLink.controller.dto.PostUserDTO;
import com.renato.LingoLink.controller.dto.ReadUserDTO;
import com.renato.LingoLink.domain.UserProfile;
import com.renato.LingoLink.service.UserProfileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("user")
public class UserProfileController {

	@Autowired
	private UserProfileService userProfileService;
	

	@PostMapping
	public ResponseEntity<?> postUserProfile(@RequestBody @Valid PostUserDTO postUserDTO,
			UriComponentsBuilder uriComponentsBuilder){

		UserProfile createNewUserProfile = userProfileService.createNewUserProfile(postUserDTO);
		URI uri = uriComponentsBuilder.path("user/{id}").buildAndExpand(createNewUserProfile.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new ReadUserDTO(createNewUserProfile));
		
	}
}
