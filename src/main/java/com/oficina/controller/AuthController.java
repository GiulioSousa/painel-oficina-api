package com.oficina.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.oficina.dto.AlterarSenhaRequestDTO;
import com.oficina.service.impl.UsuarioDetalheService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioDetalheService usuarioDetalheService;

    public AuthController(UsuarioDetalheService usuarioDetalheService) {
        this.usuarioDetalheService = usuarioDetalheService;
    }

    @GetMapping("/me")
    public ResponseEntity<Void> me(Authentication authentication) {
        if (authentication == null
                || !authentication.isAuthenticated()
                || authentication instanceof AnonymousAuthenticationToken) {
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/senha")
    public ResponseEntity<Void> alterarSenha(
            @Valid @RequestBody AlterarSenhaRequestDTO dto,
            Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()
                || authentication instanceof AnonymousAuthenticationToken) {
            return ResponseEntity.status(401).build();
        }

        usuarioDetalheService.alterarSenha(
                authentication.getName(),
                dto.getSenhaAtual(),
                dto.getNovaSenha());

        return ResponseEntity.noContent().build();
    }
}