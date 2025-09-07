package com.wildies.wildies.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wildies.wildies.enums.Sexo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "enentos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private double longitud;

    @Column(nullable = false)
    private double latitud;

    private int nivel;

    @Column(name = "edad_min")
    private int edadMin;

    @Column(name = "edad_max")
    private int edadMax;

    @Column(name = "max_participantes")
    private int maxParticipantes;

    @Column(name = "sexo_participantes")
    private Sexo sexoParticipantes;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @Column(name = "foto_portada")
    private String fotoPortada;

    @ManyToOne
    @JoinColumn(name = "deporte_id")
    private Deporte deporte;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario creador;

    @ManyToMany(mappedBy = "eventos")
    @JsonIgnore
    private List<Usuario> participantes = new ArrayList<>();

}
