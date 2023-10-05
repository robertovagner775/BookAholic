package com.bookaholic.backend.service;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookaholic.backend.model.Usuario;
import com.bookaholic.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {
    

    private UsuarioRepository repositorio;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repositorio) {
        this.repositorio = repositorio;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Usuario criarUsuario(Usuario usuario) {
        //String encoder = passwordEncoder.encode(usuario.getSenha());
        //usuario.setSenha(encoder);

      

        Usuario novoUsuario = repositorio.save(usuario);
        return novoUsuario;
    }

    public Usuario viewEmail(String email) {
        return repositorio.findByEmail(email);
    }
    public Usuario viewUsername(String username) {
        return repositorio.findByUsername(username);
    }
 
    public Boolean validarSenha(Usuario usuario) {
        String senha = repositorio.getReferenceById(usuario.getId()).getSenha();
        Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
        return valid;
    }


}
