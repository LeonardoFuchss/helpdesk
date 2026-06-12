package com.helpdesk.api.user.dto;

import lombok.Builder;

@Builder
public record UserRequestDTO(String firstName,
                             String lastName,
                             String email,
                             String password,
                             Long profileId) {
}
