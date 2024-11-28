package org.iesalandalus.programacion.robot.modelo;

public enum Orientacion {
    NORTE("Norte"),
    NORESTE("Noreste"),
    ESTE("Este"),
    SURESTE("Sureste"),
    SUR("Sur"),
    SUROESTE("Suroeste"),
    OESTE("Oeste"),
    NOROESTE("Noroeste");

    private String nombre;

    Orientacion(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        String nombre = name().toLowerCase();
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
    }

}



