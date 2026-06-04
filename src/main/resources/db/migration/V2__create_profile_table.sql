CREATE TABLE profiles (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL UNIQUE,
                          description VARCHAR(255)
);