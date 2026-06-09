package com.helpdesk.api.profile.dto;

import com.helpdesk.api.profile.domain.Permission;
import lombok.Builder;

import java.util.Set;

@Builder
public record ProfileDTO(
        String name,
        String description,
        Set<Permission> permissions) {
}
