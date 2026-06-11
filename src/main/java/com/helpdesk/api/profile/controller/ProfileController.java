package com.helpdesk.api.profile.controller;

import com.helpdesk.api.profile.dto.ProfileRequestDTO;
import com.helpdesk.api.profile.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProfileRequestDTO profileDTO) throws Exception {
        service.save(profileDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
