package com.helpdesk.api.user.repository;

import com.helpdesk.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
    Boolean existByFirstNameAndLastName(String firstName, String lastName);
}
