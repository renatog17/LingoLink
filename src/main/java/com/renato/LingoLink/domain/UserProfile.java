package com.renato.LingoLink.domain;

import java.util.Set;

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
	@Column(nullable = false, unique = true)
	private String email;
	private String phoneNumber;
	private String preferredLanguage;
	@Column(length = 500)
	private String bio; // A short bio or description about the user
	private String profilePictureUrl; // URL to the user's profile picture
	private String location; // The user's location (could be city, country, etc.)
	private String dateOfBirth; // Date of birth, consider using LocalDate in a real-world scenario
	@ManyToOne
    @JoinColumn(name = "native_language_id", nullable = false)
    private Language nativeLanguage;  // Língua nativa do usuário
    @ManyToMany
    @JoinTable(
        name = "user_learning_languages", 
        joinColumns = @JoinColumn(name = "user_profile_id"), 
        inverseJoinColumns = @JoinColumn(name = "language_id"))
    private Set<Language> learningLanguages; 
}