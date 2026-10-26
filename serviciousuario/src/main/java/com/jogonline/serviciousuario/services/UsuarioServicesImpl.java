package com.jogonline.serviciousuario.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.jogonline.serviciousuario.model.Usuario;
import com.jogonline.serviciousuario.repository.UsuarioRepository;

@Service 
public class UsuarioServicesImpl implements UsuarioServices{

    private final UsuarioRepository usuariorepository;

    public UsuarioServicesImpl(UsuarioRepository usuariorepository) {
        this.usuariorepository = usuariorepository;
    }
    @Override
    public List<Usuario> getUsuarios() {
        return usuariorepository.findAll();
    }

    @Override 
    public Usuario getUsuarioById(Long id) {
        return usuariorepository.findById(id).orElse(null);
    }

    @Override 
    public Usuario createUsuario(Usuario usuario) {
        return usuariorepository.save(usuario);
    }

    @Override 
    public Usuario updateUsuario(Long id, Usuario usuario) {
        Usuario existingUsuario = usuariorepository.findById(id).orElse(null);
        if (existingUsuario != null) {
            existingUsuario.setNombre(usuario.getNombre());
            existingUsuario.setCorreo(usuario.getCorreo());
            existingUsuario.setPassword(usuario.getPassword());
            existingUsuario.setRol(usuario.getRol());
            return usuariorepository.save(existingUsuario);
        }
        return null;
    }
    
    @Override 
    public void deleteUsuario(Long id) {
        usuariorepository.deleteById(id);
    }





}
