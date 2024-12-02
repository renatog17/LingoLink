CREATE TABLE user_profile (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    bio VARCHAR(500),
    profile_picture_url VARCHAR(255),
    gender VARCHAR(10),
    location VARCHAR(255),
    date_of_birth DATE,
    native_language_id VARCHAR (10) NOT NULL,
    FOREIGN KEY (native_language_id) REFERENCES language(code)
);