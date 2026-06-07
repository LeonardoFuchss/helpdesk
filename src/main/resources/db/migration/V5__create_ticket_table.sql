CREATE TABLE tickets (
                         id BIGSERIAL PRIMARY KEY,

                         title VARCHAR(255) NOT NULL,
                         description TEXT NOT NULL,

                         category VARCHAR(100) NOT NULL,
                         status VARCHAR(50) NOT NULL,

                         assignee_id BIGINT,
                         created_by BIGINT NOT NULL,

                         CONSTRAINT fk_ticket_assignee
                             FOREIGN KEY (assignee_id)
                                 REFERENCES users(id),

                         CONSTRAINT fk_ticket_created_by
                             FOREIGN KEY (created_by)
                                 REFERENCES users(id)
);