package com.wildies.wildies.error;

public class DeporteNotFoundException extends RuntimeException{

    public DeporteNotFoundException(Integer id){
        super("No existe deporte con id" + id);
    }

}
