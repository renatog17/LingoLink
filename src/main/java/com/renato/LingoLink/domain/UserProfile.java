package com.renato.LingoLink.domain;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(length = 500)
	private String bio;
	private String profilePictureUrl;
	private String location; // The user's location (could be city, country, etc.)
	private LocalDate dateOfBirth;
	@ManyToOne
	@JoinColumn(name = "native_language_id")
	private Language nativeLanguage;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_learning_languages", 
		joinColumns = @JoinColumn(name = "user_profile_id"), 
		inverseJoinColumns = @JoinColumn(name = "language_id"))
	private Set<Language> learningLanguages;
}