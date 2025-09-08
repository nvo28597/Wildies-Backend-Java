package com.wildies.wildies.seeder;

import java.util.List;

import com.wildies.wildies.entity.Deporte;

public class DeporteSeeder {

    public static List<Deporte> getDeportes() {

        return List.of(
                new Deporte("Montaña"),
                new Deporte("Escalada"),
                new Deporte("Bici montaña"),
                new Deporte("Bici carretera"),
                new Deporte("Surf"));
    }
}