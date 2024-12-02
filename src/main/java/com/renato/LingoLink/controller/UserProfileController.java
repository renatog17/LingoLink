package com.renato.LingoLink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renato.LingoLink.service.UserProfileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("user")
public class UserProfileController {

	@Autowired
	private UserProfileService userProfileService;
	

	@PostMapping
	public ResponseEntity<?> postUserProfile(@RequestBody @Valid PostUserDTO postUserDTO){

		userProfileService.createNewUserProfile(postUserDTO);
		
		return null;
		
	}
}
