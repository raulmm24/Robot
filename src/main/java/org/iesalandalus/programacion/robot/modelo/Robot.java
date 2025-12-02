package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public class Robot {

    private Zona zona;
    private Orientacion orientacion;
    private Coordenada coordenada;

    public Robot() {
        zona = new Zona();
        coordenada = zona.getCentro();
        orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona) {
        setZona(zona);
        setOrientacion(Orientacion.NORTE);
        setCoordenada(zona.getCentro());
    }

    public Robot(Zona zona, Orientacion orientacion) {
        setZona(zona);
        setOrientacion(orientacion);
        setCoordenada(zona.getCentro());
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        setZona(zona);
        setOrientacion(orientacion);
        setCoordenada(coordenada);
    }

    public Robot(Robot robot) {
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");
        zona = robot.getZona();
        coordenada = robot.getCoordenada();
        orientacion = robot.getOrientacion();
    }

    public Zona getZona() {
        return zona;
    }

    private void setZona(Zona zona) {
        this.zona = Objects.requireNonNull(zona, "La zona no puede ser nula.");
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    private void setOrientacion(Orientacion orientacion) {
        this.orientacion = Objects.requireNonNull(orientacion, "La orientación no puede ser nula.");
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    private void setCoordenada(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        if (!zona.pertenece(coordenada)) {
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
        this.coordenada = coordenada;
    }

    public void avanzar() {
        int nuevaCoordenadaX = coordenada.x();
        int nuevaCoordenadaY = coordenada.y();
        switch (orientacion) {
            case NORTE -> nuevaCoordenadaY++;
            case NORESTE -> { nuevaCoordenadaX++; nuevaCoordenadaY++; }
            case ESTE -> nuevaCoordenadaX++;
            case SURESTE -> { nuevaCoordenadaX++; nuevaCoordenadaY--; }
            case SUR -> nuevaCoordenadaY--;
            case SUROESTE -> { nuevaCoordenadaX--; nuevaCoordenadaY--; }
            case OESTE -> nuevaCoordenadaX--;
            case NOROESTE -> { nuevaCoordenadaX--; nuevaCoordenadaY++; }
        }
        try {
            setCoordenada(new Coordenada(nuevaCoordenadaX, nuevaCoordenadaY));
        } catch (IllegalArgumentException iae) {
            throw new RobotExcepcion("No se puede avanzar, ya que se sale de la zona.");
        }
    }

    public void girarALaDerecha() {
        orientacion = switch (orientacion) {
            case NORTE -> Orientacion.NORESTE;
            case NORESTE -> Orientacion.ESTE;
            case ESTE -> Orientacion.SURESTE;
            case SURESTE -> Orientacion.SUR;
            case SUR -> Orientacion.SUROESTE;
            case SUROESTE -> Orientacion.OESTE;
            case OESTE -> Orientacion.NOROESTE;
            case NOROESTE -> Orientacion.NORTE;
        };
    }

    public void girarALaIzquierda() {
        orientacion = switch (orientacion) {
            case NORTE -> Orientacion.NOROESTE;
            case NOROESTE -> Orientacion.OESTE;
            case OESTE -> Orientacion.SUROESTE;
            case SUROESTE -> Orientacion.SUR;
            case SUR -> Orientacion.SURESTE;
            case SURESTE -> Orientacion.ESTE;
            case ESTE -> Orientacion.NORESTE;
            case NORESTE -> Orientacion.NORTE;
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot robot)) return false;
        return Objects.equals(zona, robot.zona) && orientacion == robot.orientacion && Objects.equals(coordenada, robot.coordenada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zona, coordenada, orientacion);
    }

    @Override
    public String toString() {
        return String.format("Robot[zona=%s, coordenada=%s, orientación=%s]", this.zona, this.coordenada, this.orientacion);
    }
}