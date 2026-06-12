package com.helpdesk.api.user.dto;

import lombok.Builder;

@Builder
public record UserResponseDTO(
        String firstName,
        String lastName,
        String email,
        String profileName
) {
}
