package com.wildies.wildies.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeporteRequestDto {

    @NotBlank
    @Size(max =  30, message = "Longitud máxima es de 30 caracteres")
    private String nombre;

}
