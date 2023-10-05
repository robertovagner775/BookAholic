package com.bookaholic.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookaholic.backend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

   @Query(nativeQuery = true,value = "SELECT * FROM usuario where email = :email")
    Usuario findByEmail(String email);

    @Query(nativeQuery = true,value = "SELECT * FROM usuario where username = :username")
    Usuario findByUsername(String username);
    
}
