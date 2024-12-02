package com.renato.LingoLink.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Language {

	@Id
	private String code;  // Código ISO da língua, como "en", "es", etc.
    @Column(nullable = false, unique = true)
    private String name; 
    @OneToMany(mappedBy = "nativeLanguage")  // Marks the inverse side of the Many-to-One relationship
    private Set<UserProfile> usersWithNativeLanguage;  // Users who have this language as their native language
    // This relationship is the inverse side of the @ManyToMany in UserProfile
    @ManyToMany(mappedBy = "learningLanguages")  // Marks the inverse side of the Many-to-Many relationship
    private Set<UserProfile> usersLearning;
}