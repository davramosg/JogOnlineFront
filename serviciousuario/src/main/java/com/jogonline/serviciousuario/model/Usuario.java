package com.jogonline.serviciousuario.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Table (name = "usuario")
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id 
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column (name = "nombre", columnDefinition = "TEXT")
    private String nombre;
    @Column (name= "correo", columnDefinition = "TEXT")
    private String correo;
    @Column (name= "password", columnDefinition = "TEXT")
    private String password;
    @Column (name= "rol", columnDefinition = "TEXT")
    private String rol;


}
