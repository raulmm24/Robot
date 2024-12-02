package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public class Robot {
    private Zona zona;
    private Orientacion orientacion;
    private Coordenada coordenada;
    public Robot(){
        this.zona = new Zona();
        this.orientacion = Orientacion.NORTE;
        this.coordenada = new Coordenada(5,5);
    }

    public Robot(Zona zona) {
        if (zona != null) {
            this.zona = zona;
        } else {
            throw new NullPointerException("La zona no puede ser nula.");
        }
        this.coordenada = this.zona.getCentro();
        this.orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona, Orientacion orientacion) {
        if (zona != null) {
            this.zona = zona;
        } else {
            throw new NullPointerException("La zona no puede ser nula.");
        }
        if (orientacion != null) {
            this.orientacion = orientacion;
        } else {
            throw new NullPointerException("La orientación no puede ser nula.");
        }
        this.coordenada = this.zona.getCentro();
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        if (zona != null) {
            this.zona = zona;
        } else {
            throw new NullPointerException("La zona no puede ser nula.");
        }
        if (orientacion != null) {
            this.orientacion = orientacion;
        } else {
            throw new NullPointerException("La orientación no puede ser nula.");
        }
        if (coordenada != null) {
            this.coordenada = coordenada;
        } else {
            throw new NullPointerException("La coordenada no puede ser nula.");
        }
        if (this.coordenada.x() > this.zona.ancho() || this.coordenada.y() > this.zona.alto() || this.coordenada.x() < 0 || this.coordenada.y() < 0) {
          throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
    }

    public Robot(Robot robot){
        if (robot != null) {
            this.zona = robot.getZona();
            this.coordenada = robot.getCoordenada();
            this.orientacion = robot.getOrientacion();
        } else {
            throw new NullPointerException("El robot no puede ser nulo.");
        }

    }

    public Zona getZona() {
        return zona;
    }

    private void setZona(Zona zona) {
        this.zona = zona;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    private void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    private void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public void avanzar() {
        Coordenada coordenada = switch (orientacion) {
            case NORTE -> new Coordenada(this.coordenada.x(), this.coordenada.y()+ 1);
            case NORESTE -> new Coordenada(this.coordenada.x() + 1, this.coordenada.y() + 1);
            case ESTE -> new Coordenada(this.coordenada.x() + 1, this.coordenada.y());
            case SURESTE -> new Coordenada(this.coordenada.x() + 1, this.coordenada.y() - 1);
            case SUR -> new Coordenada(this.coordenada.x(), this.coordenada.y() - 1);
            case SUROESTE -> new Coordenada(this.coordenada.x() - 1, this.coordenada.y() - 1);
            case OESTE -> new Coordenada(this.coordenada.x() - 1, this.coordenada.y());
            case NOROESTE -> new Coordenada(this.coordenada.x() - 1, this.coordenada.y() + 1);
        };
        if (coordenada.x() >= 0 && coordenada.x() < this.zona.ancho() && coordenada.y() >= 0 && coordenada.y() < this.zona.alto()) {
            setCoordenada(coordenada);
        } else throw new RobotExcepcion("No se puede avanzar, ya que se sale de la zona.");
    }

    public void girarALaDerecha() {
        switch (orientacion) {
            case NORTE -> orientacion = Orientacion.NORESTE;
            case NORESTE -> orientacion = Orientacion.ESTE;
            case ESTE -> orientacion = Orientacion.SURESTE;
            case SURESTE -> orientacion = Orientacion.SUR;
            case SUR -> orientacion = Orientacion.SUROESTE;
            case SUROESTE -> orientacion = Orientacion.OESTE;
            case OESTE -> orientacion = Orientacion.NOROESTE;
            case NOROESTE -> orientacion = Orientacion.NORTE;
        }
    }

    public void girarALaIzquierda() {
        switch (orientacion) {
            case NORTE -> orientacion = Orientacion.NOROESTE;
            case NOROESTE -> orientacion = Orientacion.OESTE;
            case OESTE -> orientacion = Orientacion.SUROESTE;
            case SUROESTE -> orientacion = Orientacion.SUR;
            case SUR -> orientacion = Orientacion.SURESTE;
            case SURESTE -> orientacion = Orientacion.ESTE;
            case ESTE -> orientacion = Orientacion.NORESTE;
            case NORESTE -> orientacion = Orientacion.NORTE;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Robot ) {
            Robot robot = (Robot) o;
            return Objects.equals(zona, robot.zona) && orientacion == robot.orientacion && Objects.equals(coordenada, robot.coordenada);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(zona, coordenada, orientacion);
    }

    @Override
    public String toString() {
        return "Robot{" + "zona=" + zona + ", orientacion=" + orientacion + ", coordenada=" + coordenada + '}';
    }

}
