package com.helpdesk.api.profile.repository;

import com.helpdesk.api.profile.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Boolean existsByName(String name);
}
