package com.helpdesk.api.profile;

import com.helpdesk.api.profile.domain.Permission;
import com.helpdesk.api.profile.domain.Profile;
import com.helpdesk.api.profile.repository.ProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProfileIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ProfileRepository repository;

    @BeforeEach
    void setup() {
        repository.deleteAll();
    }

    @Test
    void shouldSaveProfile() throws Exception {

        String json = """
                {
                    "name": "Teste",
                    "description": "Administrador",
                    "permissions": ["PROFILE_READ"]
                }
                """;

        mvc.perform(post("/profiles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());

        assertTrue(repository.existsByName("Teste"));
    }

    @Test
    void shouldReturnAllProfiles() throws Exception {
        Profile profile = new Profile();
        profile.setName("Teste");
        profile.setDescription("Administrador");
        profile.setPermission(Set.of(Permission.PROFILE_READ));

        repository.save(profile);

        mvc.perform(get("/profiles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void shouldReturnProfileById() throws Exception {
        Profile profile = new Profile();
        profile.setName("Teste");
        profile.setDescription("Administrador");
        profile.setPermission(Set.of(Permission.PROFILE_READ));

        profile = repository.save(profile);

        mvc.perform(get("/profiles/{id}", profile.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Teste"))
                .andExpect(jsonPath("$.description").value("Administrador"));
    }

    @Test
    void shouldUpdateProfile() throws Exception {

        Profile profile = new Profile();
        profile.setName("Admin");
        profile.setDescription("Administrador");
        profile.setPermission(Set.of(Permission.PROFILE_READ));

        profile = repository.save(profile);

        String json = """
                {
                    "name": "Comum",
                    "description": "Usuário comum",
                    "permissions": ["PROFILE_READ"]
                }
                """;

        mvc.perform(put("/profiles/{id}", profile.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isNoContent());

        Profile updatedProfile =
                repository.findById(profile.getId()).orElseThrow();

        assertEquals("Comum", updatedProfile.getName());
        assertEquals("Usuário comum", updatedProfile.getDescription());
    }
}