package com.renato.LingoLink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renato.LingoLink.domain.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{

}
