package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public record Zona(int ancho, int alto) {
    private static final int ANCHO_MINIMO = 10;
    private static final int ANCHO_MAXIMO = 100;
    private static final int ALTURA_MINIMA = 10;
    private static final int ALTURA_MAXIMA = 100;

    public Zona {
        validarAncho(ancho);
        validarAlto(alto);
    }

    public Zona() {
        this(ANCHO_MINIMO, ALTURA_MINIMA);
    }

    private void validarAncho(int ancho) {
        if (ancho < ANCHO_MINIMO) {
            throw new IllegalArgumentException("Ancho no válido.");
        } else if (ancho > ANCHO_MAXIMO) {
            throw new IllegalArgumentException("Ancho no válido.");
        }
    }

    private void validarAlto(int alto) {
        if (alto < ALTURA_MINIMA) {
            throw new IllegalArgumentException("Alto no válido.");
        } else if (alto > ALTURA_MAXIMA) {
            throw new IllegalArgumentException("Alto no válido.");
        }
    }

    public Coordenada getCentro() {
        return new Coordenada(ancho/ 2, alto/ 2);
    }

    public boolean pertenece(Coordenada coordenada) {
        Objects.requireNonNull(coordenada,"La coordenada no puede ser nula.");
        return perteneceX(coordenada.x()) && perteneceY(coordenada.y());
    }

    private boolean perteneceX(int x) {
        return (x >= 0 && x < ancho);
    }

    private boolean perteneceY(int y) {
        return (y >= 0 && y < alto);
    }
}


