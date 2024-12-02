CREATE TABLE user_learning_languages (
    user_profile_id BIGINT NOT NULL,
    language_id BIGINT NOT NULL,
    PRIMARY KEY (user_profile_id, language_id),
    FOREIGN KEY (user_profile_id) REFERENCES user_profile(id),
    FOREIGN KEY (language_id) REFERENCES language(id)
);