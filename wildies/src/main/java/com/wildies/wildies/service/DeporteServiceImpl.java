package com.wildies.wildies.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wildies.wildies.dto.request.DeporteRequestDto;
import com.wildies.wildies.dto.response.DeporteResponseDto;
import com.wildies.wildies.entity.Deporte;
import com.wildies.wildies.error.DeporteNotFoundException;
import com.wildies.wildies.repository.DeporteRepository;

@Service
public class DeporteServiceImpl implements DeporteService {

    private DeporteRepository deporteRepository;

    public DeporteServiceImpl(DeporteRepository deporteRepository) {
        this.deporteRepository = deporteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public DeporteResponseDto findById(Integer id) {
        Deporte deporte = deporteRepository.findById(id).orElseThrow(() -> new DeporteNotFoundException(id));
        return new DeporteResponseDto(deporte);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DeporteResponseDto> findAll() {
        List<Deporte> deportes = deporteRepository.findAll();
        List<DeporteResponseDto> deportesToReturn = new ArrayList<>();
        for (Deporte deporte : deportes) {
            deportesToReturn.add(new DeporteResponseDto(deporte));
        }
        return deportesToReturn;
    }

    @Override
    @Transactional
    public DeporteResponseDto save(DeporteRequestDto deporteRequestDto) {
        Deporte deporte = new Deporte();
        deporte.setNombre(deporteRequestDto.getNombre());
        Deporte deporteGuardado = deporteRepository.save(deporte);
        return new DeporteResponseDto(deporteGuardado);
    }

    @Override
    @Transactional
    public void saveAll(List<Deporte> deportes) {
        deporteRepository.saveAll(deportes);

    }

    @Override
    @Transactional
    public DeporteResponseDto update(Integer id, DeporteRequestDto deporteRequestDto) {
        Deporte deporte = deporteRepository.findById(id).orElseThrow(() -> new DeporteNotFoundException(id));
        deporte.setNombre(deporteRequestDto.getNombre());
        Deporte deporteActualizado = deporteRepository.save(deporte);
        return new DeporteResponseDto(deporteActualizado);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        deporteRepository.findById(id).orElseThrow(() -> new DeporteNotFoundException(id));
        deporteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        deporteRepository.deleteAll();
    }

}
