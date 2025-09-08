package com.wildies.wildies.service;

import java.util.List;

import com.wildies.wildies.dto.request.DeporteRequestDto;
import com.wildies.wildies.dto.response.DeporteResponseDto;
import com.wildies.wildies.entity.Deporte;

public interface DeporteService {

    DeporteResponseDto findById(Integer id);

    List <DeporteResponseDto> findAll();

    DeporteResponseDto save(DeporteRequestDto deporte);

    void saveAll(List <Deporte> deportes);

    DeporteResponseDto update(Integer id, DeporteRequestDto deporte);

    void delete(Integer id);

    void deleteAll();
    

   

}
