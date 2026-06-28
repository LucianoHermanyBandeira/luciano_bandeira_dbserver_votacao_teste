CREATE  TABLE IF NOT EXISTS user_associated (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS polls (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    theme VARCHAR(255) NOT NULL,
    time_length BIGINT NOT NULL,
    start_time TIMESTAMP,
    end_time TIMESTAMP
);

CREATE TABLE IF NOT EXISTS votes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_associated_id BIGINT NOT NULL,
    poll_id BIGINT NOT NULL,
    vote VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_associated_id) REFERENCES user_associated(id),
    FOREIGN KEY (poll_id) REFERENCES polls(id)
);