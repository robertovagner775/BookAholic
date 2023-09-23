package com.bookaholic.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String senha;
}
