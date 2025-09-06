package com.wildies.wildies.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="usuarios_deportes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDeporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nivel;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "deporte_id")
    private Deporte deporte;

    @OneToMany(mappedBy = "usuarioDeporte", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List <UsuarioDeporteParametro> usuarioDeporteParametros;

}
