package com.jogonline.serviciousuario.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jogonline.serviciousuario.model.Usuario;
import com.jogonline.serviciousuario.services.UsuarioServices;


@RestController 
@RequestMapping ("/api/usuario")
public class UsuarioController {

    private final UsuarioServices usuarioServices;

    public UsuarioController(UsuarioServices usuarioServices) {
        this.usuarioServices = usuarioServices;
    }

    @GetMapping 
    public List<Usuario> getUsuarios() {
        return usuarioServices.getUsuarios();
    }
    @GetMapping ("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioServices.getUsuarioById(id);
    }
    @PostMapping 
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        if (usuario.getPassword() == null || usuario.getPassword().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "El campo 'password' o 'contrasena' es obligatorio");
        }
        return usuarioServices.createUsuario(usuario);
    }
    @PutMapping ("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioServices.updateUsuario(id, usuario);
    }
    @DeleteMapping 
    public void deleteUsuario(@PathVariable Long id) {
        usuarioServices.deleteUsuario(id);
    }
    @DeleteMapping ("/{id}")
    public void deleteUsuarioById(@PathVariable Long id) {
        usuarioServices.deleteUsuario(id);
    }


}
