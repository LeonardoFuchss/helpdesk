package com.helpdesk.api.profile.mapper;

import com.helpdesk.api.profile.domain.Profile;
import com.helpdesk.api.profile.dto.ProfileDTO;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    public Profile dtoToEntity(ProfileDTO dto) {
        return Profile.builder()
                .name(dto.name())
                .description(dto.description())
                .permission(dto.permissions())
                .build();
    }
    public ProfileDTO entityToDto(Profile profile) {
        return ProfileDTO.builder()
                .name(profile.getName())
                .description(profile.getDescription())
                .permissions(profile.getPermission())
                .build();
    }
}
