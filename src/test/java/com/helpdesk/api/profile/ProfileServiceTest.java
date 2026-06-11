package com.helpdesk.api.profile;

import com.helpdesk.api.profile.domain.Permission;
import com.helpdesk.api.profile.domain.Profile;
import com.helpdesk.api.profile.dto.ProfileRequestDTO;
import com.helpdesk.api.profile.dto.ProfileResponseDTO;
import com.helpdesk.api.profile.mapper.ProfileMapper;
import com.helpdesk.api.profile.repository.ProfileRepository;
import com.helpdesk.api.profile.service.ProfileService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
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
        ProfileRequestDTO dto = new ProfileRequestDTO(
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
        ProfileRequestDTO dto = new ProfileRequestDTO(
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
    @Test
    void shouldReturnAllProfiles() {
        List<Profile> profiles = List.of(new Profile(), new Profile());
        when(repository.findAll()).thenReturn(profiles); /* Configurando mock para retornar uma lista de perfis definidas anteriormente*/
        List<ProfileResponseDTO> result = service.findAll();
        assertEquals(2, result.size());
        verify(repository).findAll();
        /* profiles e result referencial a mesma lista definida no mock */
    }
    @Test
    void shouldReturnProfileById() {
        Profile profile = new Profile();
        profile.setId(1L);
        profile.setName("Admin");
        profile.setDescription("Administrador");

        ProfileResponseDTO response = new ProfileResponseDTO("Admin", "Administrador");
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(profile)); /* mock para retornar o profile */
        when(mapper.entityToDto(profile)).thenReturn(response); /* mock para retornar o response */

        ProfileResponseDTO result = service.findById(1L);
        assertEquals(response, result);
        verify(repository).findById(1L);
        verify(mapper).entityToDto(profile);
    }
    @Test
    void shouldUpdateProfile() {
        Profile profile = new Profile();
        profile.setId(1L);
        profile.setName("Admin");
        profile.setDescription("Administrador");
        ProfileRequestDTO dto = new ProfileRequestDTO("Comum", "Usuário comum", Set.of(Permission.values()));
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(profile));
        service.update(1L, dto);
        assertEquals("Comum", profile.getName());
        assertEquals("Usuário comum", profile.getDescription());
        verify(repository).findById(1L);
        verify(repository).save(profile);
    }
}
