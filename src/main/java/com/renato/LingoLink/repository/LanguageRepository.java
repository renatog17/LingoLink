package com.renato.LingoLink.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renato.LingoLink.domain.Language;

public interface LanguageRepository extends JpaRepository<Language, String>{

	Set<Language> findByCodeIn(Set<String> codes);
}
