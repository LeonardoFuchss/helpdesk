package com.helpdesk.api.profile.dto;

import lombok.Builder;

@Builder
public record ProfileResponseDTO(String name,
                                 String description) {
}
