package com.helpdesk.api.user.controller;

import com.helpdesk.api.user.dto.UserRequestDTO;
import com.helpdesk.api.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserRequestDTO userDTO) {
        service.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
