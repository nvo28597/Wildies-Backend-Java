package com.wildies.wildies.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "parametros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parametro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 30)
    @NotBlank
    @Size(max = 30, message = "El campo nombre como máximo puede tener 30 caracteres")
    private String nombre;

    @ManyToMany(mappedBy = "parametros")
    @JsonIgnore
    private List <Deporte> deportes = new ArrayList<>();

    @OneToMany(mappedBy = "parametro", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List <UsuarioDeporteParametro> usuarioDeporteParametros = new ArrayList<>();


}
