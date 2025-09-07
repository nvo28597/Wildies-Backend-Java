package com.wildies.wildies.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wildies.wildies.enums.Sexo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(length = 30, nullable = false, unique = true)
    @Size(min = 5, max = 30)
    @NotBlank
    private String email;

    @NotBlank
    @Column(length = 20, nullable = false)
    @Size(min = 4, max = 20, message = "La contraseña tiene que tener entre 4 y 20 caracteres")
    private String password;

    @NotBlank
    @Column(length = 50, nullable = false)
    @Size(max = 50, message = "El campo nombre tiene que tener hasta 50 caracteres")
    private String nombre;

    @NotBlank
    @Column(length = 50, nullable = false)
    @Size(max = 50, message = "El campo apellidos tiene que tener hasta 50 caracteres")
    private String apellidos;

    @NotNull
    @Column(name="fecha_nacimiento", nullable = false)
    @Past
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private double longitudDomicilio;

    private double latitudDomicilio;

    @Column(length = 50)
    private String profesion;

    private String idiomas;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    private String descripcion;

    @Column(name="por_que")
    private String porQue;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List <UsuarioDeporte> usuariosDeportes;

    @OneToMany(mappedBy = "solicitante", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List <Amistad> amigosEnviados;

    @OneToMany(mappedBy = "amigo", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List <Amistad> amigosRecibidos;

    @OneToMany(mappedBy = "creador")
    @JsonIgnore
    private List<Evento> eventosCreados = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "evento_usuario",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private List<Evento> eventos = new ArrayList<>();

    
    
}
