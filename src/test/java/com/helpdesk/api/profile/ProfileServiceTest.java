package com.helpdesk.api.profile;

import com.helpdesk.api.profile.domain.Permission;
import com.helpdesk.api.profile.domain.Profile;
import com.helpdesk.api.profile.dto.ProfileDTO;
import com.helpdesk.api.profile.mapper.ProfileMapper;
import com.helpdesk.api.profile.repository.ProfileRepository;
import com.helpdesk.api.profile.service.ProfileService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProfileServiceTest {
    @Mock
    private ProfileRepository repository;
    @InjectMocks
    private ProfileService service;
    @Mock
    private ProfileMapper mapper;

    @Test
    void shouldSetCreatedAtAndSaveProfile() throws Exception {
        // Criando DTO
        ProfileDTO dto = new ProfileDTO(
                "Admin",
                "Administrador",
                Set.of(Permission.values())
        );
        // Criando entidade
        Profile profile = new Profile();
        // Quando o DTO for chamado, retorna a entidade
        when(mapper.dtoToEntity(dto))
                .thenReturn(profile);
        // Executa o método que está sendo testado
        service.save(dto);
        // Criando um capturador para interceptar o objeto
        ArgumentCaptor<Profile> captor =
                ArgumentCaptor.forClass(Profile.class);
        // Verifica se o save foi chamado com a entidade
        // Capturando a entidade Profile enviado para ele
        verify(repository).save(captor.capture());
        // Recuperando a entidade capturada
        Profile savedProfile = captor.getValue();
        // Valida se o createdAt foi setado
        // Antes de salvar, o createdAt deve ser setado
        assertNotNull(savedProfile.getCreatedAt());
    }

    @Test
    void shouldNotSaveProfileWhenNameAlreadyExists() {
        ProfileDTO dto = new ProfileDTO(
                "Admin",
                "Administrador",
                Set.of(Permission.values())
        );
        Profile profile = new Profile();
        when(mapper.dtoToEntity(dto))
                .thenReturn(profile);
        when(repository.existsByName(profile.getName()))
                .thenReturn(true);

        assertThrows(Exception.class, () -> service.save(dto));
        verify(repository, Mockito.never()).save(ArgumentMatchers.any(Profile.class));
    }
}
