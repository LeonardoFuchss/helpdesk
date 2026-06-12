package com.helpdesk.api.user;

import com.helpdesk.api.profile.domain.Profile;
import com.helpdesk.api.profile.repository.ProfileRepository;
import com.helpdesk.api.user.domain.User;
import com.helpdesk.api.user.dto.UserRequestDTO;
import com.helpdesk.api.user.dto.UserResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {
    private final ProfileRepository profileRepository;

    public User dtoToEntity(UserRequestDTO dto) {
        Profile profile = profileRepository.findById(dto.profileId()).orElseThrow();
        return User.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .email(dto.email())
                .password(dto.password())
                .profile(profile)
                .build();
    }
    public UserResponseDTO entityToDto(User user) {
        return UserResponseDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .profileName(user.getProfile().getName())
                .build();
    }
}
