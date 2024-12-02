CREATE TABLE user_profile (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone_number VARCHAR(20),
    preferred_language VARCHAR(10),
    bio VARCHAR(500),
    profile_picture_url VARCHAR(255),
    gender VARCHAR(10),
    location VARCHAR(255),
    date_of_birth DATE,
    native_language_id BIGINT NOT NULL,
    FOREIGN KEY (native_language_id) REFERENCES language(id)
);