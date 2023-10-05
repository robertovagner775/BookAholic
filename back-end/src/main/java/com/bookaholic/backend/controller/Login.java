package com.bookaholic.backend.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookaholic.backend.model.ErrorResponse;
import com.bookaholic.backend.model.LoginDto;
import com.bookaholic.backend.model.Usuario;
import com.bookaholic.backend.repository.UsuarioRepository;
import com.bookaholic.backend.service.UsuarioService;

import lombok.Getter;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class Login  {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    @ResponseBody
    public ResponseEntity<Usuario> getMethodName(@RequestBody String email) {
        return ResponseEntity.status(200).body(usuarioRepository.findByEmail(email));
    }
    

    @PostMapping
    public ResponseEntity<?>  addUsuario(@RequestBody  Usuario usuario){
        if(usuarioRepository.findByEmail(usuario.getEmail()) != null || 
        usuarioRepository.findByUsername(usuario.getUsername()) != null) {
            return ResponseEntity.status(200).body( new ErrorResponse(200, "error - inserir usuario", "username ou email já existe"));
        }
      
        return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
    
    }


    @PostMapping("/login") 
    public ResponseEntity<?> login(@RequestBody LoginDto login){
        
        Usuario usuario = usuarioRepository.findByEmail(login.email());
       // Boolean valid = usuarioService.validarSenha(usuario);

        if(usuario != null) {

            return ResponseEntity.ok().body(usuario);

        }
        return ResponseEntity.badRequest().body(new ErrorResponse(0, "Usuario não encontrado", "usuario não esta cadastrado"));


        
    }



}
