package com.helpdesk.api.user.domain;

import com.helpdesk.api.profile.domain.Profile;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToOne(fetch = FetchType.LAZY) // Carrega o Profile apenas quando acessado
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
