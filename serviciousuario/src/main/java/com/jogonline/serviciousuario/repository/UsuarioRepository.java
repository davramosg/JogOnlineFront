package com.jogonline.serviciousuario.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jogonline.serviciousuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    java.util.List<Usuario> findByNombre(String nombre);
    com.jogonline.serviciousuario.model.Usuario findByCorreo(String correo);

    com.jogonline.serviciousuario.model.Usuario findByCorreoAndPassword(String correo, String password);

 



    
    

}
