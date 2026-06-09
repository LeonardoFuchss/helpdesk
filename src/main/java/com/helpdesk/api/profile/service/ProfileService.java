package com.helpdesk.api.profile.service;

import com.helpdesk.api.profile.domain.Profile;
import com.helpdesk.api.profile.dto.ProfileDTO;
import com.helpdesk.api.profile.mapper.ProfileMapper;
import com.helpdesk.api.profile.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ProfileService {
    private final ProfileRepository repository;
    private final ProfileMapper mapper;

    @Transactional
    public void save(ProfileDTO profileDTO) {
        Profile profile = mapper.dtoToEntity(profileDTO);
        profile.setCreatedAt(LocalDateTime.now());
        repository.save(profile);
    }
}
