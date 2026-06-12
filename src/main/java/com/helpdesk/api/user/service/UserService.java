package com.helpdesk.api.user.service;

import com.helpdesk.api.user.UserMapper;
import com.helpdesk.api.user.domain.User;
import com.helpdesk.api.user.dto.UserRequestDTO;
import com.helpdesk.api.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final UserRepository repository;

    @Transactional
    public void save(UserRequestDTO dto) {
        User user = mapper.dtoToEntity(dto);
        user.setCreatedAt(LocalDateTime.now());
        if (repository.existsByEmail(user.getEmail()) || repository.existByFirstNameAndLastName(dto.lastName(), dto.firstName())) {
            throw new RuntimeException("User already exists");
        }
        repository.save(user);
    }
}
