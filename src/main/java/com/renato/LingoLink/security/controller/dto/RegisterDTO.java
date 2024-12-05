package com.renato.LingoLink.security.controller.dto;

import com.renato.LingoLink.security.domain.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}