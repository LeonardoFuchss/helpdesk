CREATE TABLE ticket_stories (
                                id BIGSERIAL PRIMARY KEY,
                                description VARCHAR(255),
                                ticket_id BIGINT NOT NULL,
                                user_id BIGINT NOT NULL,
                                created_at TIMESTAMP NOT NULL,
                                updated_at TIMESTAMP,

                                CONSTRAINT fk_ticket_stories_ticket
                                    FOREIGN KEY (ticket_id)
                                        REFERENCES tickets(id),

                                CONSTRAINT fk_ticket_stories_user
                                    FOREIGN KEY (user_id)
                                        REFERENCES users(id)
);