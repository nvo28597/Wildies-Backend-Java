package com.wildies.wildies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildies.wildies.entity.Deporte;

@Repository
public interface DeporteRepository extends JpaRepository<Deporte, Integer>{

}
