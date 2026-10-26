package com.jogonline.serviciousuario.services;

import java.util.List;

import com.jogonline.serviciousuario.model.Usuario;

public interface UsuarioServices {

    List<Usuario> getUsuarios();
    Usuario getUsuarioById(Long id);
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(Long id, Usuario usuario);
    void deleteUsuario(Long id);
}
