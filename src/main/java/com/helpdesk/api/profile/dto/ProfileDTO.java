package com.helpdesk.api.profile.dto;

import com.helpdesk.api.profile.domain.Permission;

import java.util.Set;

public record ProfileDTO(String name, String description, Set<Permission> permissions) {
}
