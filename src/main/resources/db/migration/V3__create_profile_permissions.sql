CREATE TABLE profile_permissions (
                                     profile_id BIGSERIAL NOT NULL,
                                     permission VARCHAR(100) NOT NULL,

                                     CONSTRAINT fk_profile_permissions_profile
                                         FOREIGN KEY (profile_id)
                                             REFERENCES profiles(id)
                                             ON DELETE CASCADE
);