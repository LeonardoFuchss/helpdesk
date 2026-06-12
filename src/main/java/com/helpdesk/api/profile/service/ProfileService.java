package com.helpdesk.api.profile.service;

import com.helpdesk.api.profile.domain.Profile;
import com.helpdesk.api.profile.domain.Status;
import com.helpdesk.api.profile.dto.ProfileRequestDTO;
import com.helpdesk.api.profile.dto.ProfileResponseDTO;
import com.helpdesk.api.profile.mapper.ProfileMapper;
import com.helpdesk.api.profile.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfileService {
    private final ProfileRepository repository;
    private final ProfileMapper mapper;

    @Transactional
    public void save(ProfileRequestDTO profileDTO) throws Exception {
        Profile profile = mapper.dtoToEntity(profileDTO);
        profile.setCreatedAt(LocalDateTime.now());
        profile.setStatus(Status.ACTIVE);
        if (repository.existsByName(profile.getName())) {
            throw new Exception("O perfil informado já existe.");
        }
        repository.save(profile);
    }
    public List<ProfileResponseDTO> findAll() {
        List<Profile> profiles = repository.findAll();
        return profiles
                .stream()
                .map(mapper::entityToDto)
                .toList();
    }
    public ProfileResponseDTO findById(Long id) {
        Optional<Profile> profile = repository.findById(id);
        if (profile.isPresent()) {
            return mapper.entityToDto(profile.get());
        }
        throw new RuntimeException("Profile not found");
    }
    @Transactional
    public void update(Long id, ProfileRequestDTO profileDTO) {
        Optional<Profile> profile = repository.findById(id);
        if (profile.isPresent()) {
            profile.get().update(profileDTO);
            repository.save(profile.get());
        }
    }
}
