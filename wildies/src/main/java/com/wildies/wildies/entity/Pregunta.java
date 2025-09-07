package com.wildies.wildies.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="preguntas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255, nullable = false)
    @Size(max = 255, message = "Longituda máxima es de 255 caracteres")
    @NotBlank
    private String texto;

    @ManyToOne
    @JoinColumn(name = "deporte_id")
    private Deporte deporte;

    @OneToMany(mappedBy = "pregunta")
    @JsonIgnore
    private List <Respuesta> respuestas;


}
