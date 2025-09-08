package com.wildies.wildies.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.wildies.wildies.entity.Deporte;
import com.wildies.wildies.entity.Parametro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeporteResponseDto {

    private int id;

    private String nombre;

    private List<Parametro> parametros = new ArrayList<>();

    public DeporteResponseDto(Deporte deporte) {
        this.id = deporte.getId();
        this.nombre = deporte.getNombre();
        this.parametros = deporte.getParametros();
    }

}
