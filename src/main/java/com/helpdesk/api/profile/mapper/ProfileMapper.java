package com.helpdesk.api.profile.mapper;

import com.helpdesk.api.profile.domain.Profile;
import com.helpdesk.api.profile.dto.ProfileRequestDTO;
import com.helpdesk.api.profile.dto.ProfileResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    public Profile dtoToEntity(ProfileRequestDTO dto) {
        return Profile.builder()
                .name(dto.name())
                .description(dto.description())
                .permission(dto.permissions())
                .build();
    }
    public ProfileResponseDTO entityToDto(Profile profile) {
        return ProfileResponseDTO.builder()
                .name(profile.getName())
                .description(profile.getDescription())
                .build();
    }
}
