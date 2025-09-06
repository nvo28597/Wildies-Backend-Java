package com.wildies.wildies.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "respuestas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255, nullable = false)
    @NotBlank
    @Size(max=255, message="La longituda máxima es de 255 caracteres")
    private String texto;

    @Min(1)
    @Max(4)
    private int puntuacion;

    @ManyToOne
    @JoinColumn(name = "pregunta_id")
    private Pregunta pregunta;




}
