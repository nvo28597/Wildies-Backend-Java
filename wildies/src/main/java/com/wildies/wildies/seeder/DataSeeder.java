package com.wildies.wildies.seeder;

import java.util.List;

import org.springframework.boot.CommandLineRunner;

import com.wildies.wildies.entity.Deporte;
import com.wildies.wildies.service.DeporteService;

public class DataSeeder implements CommandLineRunner{

    private DeporteService deporteService;

    public DataSeeder(DeporteService deporteService){
        this.deporteService = deporteService;
    }

    @Override
    public void run(String... args) throws Exception {
        
        deporteService.deleteAll();
        List <Deporte> deportes = DeporteSeeder.getDeportes();
        deporteService.saveAll(deportes);
    }
    


}
