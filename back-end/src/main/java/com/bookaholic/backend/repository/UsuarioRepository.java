package com.bookaholic.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookaholic.backend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
