package com.bookaholic.backend.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookaholic.backend.model.Usuario;
import com.bookaholic.backend.repository.UsuarioRepository;

import lombok.Getter;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class Login  {

    @Autowired
    private UsuarioRepository repositorio;

    @PostMapping
    public void retorna(@RequestBody Usuario usuario){
       Usuario usuarioNovo = repositorio.save(usuario);
    
    }



}
