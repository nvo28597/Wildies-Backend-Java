package com.wildies.wildies.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="usuarios_deportes_parametros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDeporteParametro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String valor;

    @ManyToOne
    @JoinColumn(name = "usuario_deporte_id")
    private UsuarioDeporte usuarioDeporte;

    @ManyToOne
    @JoinColumn(name = "parametro_id")
    private Parametro parametro;

}
