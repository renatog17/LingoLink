package com.renato.LingoLink.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.renato.LingoLink.security.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	UserDetails findByLogin(String login);
}