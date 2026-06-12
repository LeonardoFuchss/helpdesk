package com.helpdesk.api.profile.domain;

import com.helpdesk.api.profile.dto.ProfileRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ElementCollection(targetClass = Permission.class)
    // Indica que este atributo será uma coleção embarcada, ou seja, uma tabela auxiliar
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "profile_permissions", joinColumns = @JoinColumn(name = "profile_id"))
    private Set<Permission> permission;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public void update(ProfileRequestDTO profileDTO) {
        this.name = profileDTO.name();
        this.description = profileDTO.description();
        this.permission = profileDTO.permissions();
    }
}
