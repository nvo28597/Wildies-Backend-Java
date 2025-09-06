package com.wildies.wildies.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@Table(name = "deportes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Deporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 30, message = "Longitud máxima es de 30 caracteres")
    @Column(length = 30, unique = true, nullable = false)
    private String nombre;

    @ManyToMany
    @JoinTable(
        name = "deporte_parametro", 
        joinColumns = @JoinColumn(name = "deporte_id"), 
        inverseJoinColumns = @JoinColumn(name = "parametro_id")
        )
    private List<Parametro> parameters;

    @OneToMany(mappedBy = "deporte")
    @JsonIgnore
    private List<Pregunta> preguntas;

    @OneToMany(mappedBy = "deporte", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<UsuarioDeporte> usuarioDeportes;

}
