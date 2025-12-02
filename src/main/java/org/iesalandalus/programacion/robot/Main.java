package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.robot.vista.Consola;


public class Main {

    private static ControladorRobot controladorRobot;

    public static void main(String[] args) {
        int opcion;
        do {
            Consola.mostrarMenuPrincipal();
            opcion = Consola.elegirOpcion();
            if (opcion != 0) {
                ejecutarOpcion(opcion);
                Consola.mostrarRobot(controladorRobot);
            }
        } while (opcion != 0);
        Consola.despedirse();
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> controlarRobotDefecto();
            case 2 -> controlarRobotZona();
            case 3 -> controlarRobotZonaOrientacion();
            case 4 -> controlarRobotZonaOrientacionCoordenada();
            case 5 -> ejecutarComando();
            default -> { /*No hacer nada*/ }
        }
    }

    private static void controlarRobotDefecto() {
        controladorRobot = new ControladorRobot(new Robot());
    }

    private static void controlarRobotZona() {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona()));
    }

    private static void controlarRobotZonaOrientacion() {
        Zona zona = Consola.elegirZona();
        Consola.mostrarMenuOrientacion();
        Orientacion orientacion = Consola.elegirOrientacion();
        controladorRobot = new ControladorRobot(new Robot(zona, orientacion));
    }

    private static void controlarRobotZonaOrientacionCoordenada() {
        Zona zona = Consola.elegirZona();
        Consola.mostrarMenuOrientacion();
        Orientacion orientacion = Consola.elegirOrientacion();
        Coordenada coordenada = Consola.elegirCoordenada();
        try {
            controladorRobot = new ControladorRobot(new Robot(zona, orientacion, coordenada));
        } catch (IllegalArgumentException iae) {
            System.out.println("ERROR: " + iae.getMessage());
        }
    }

    private static void ejecutarComando() {
        if (controladorRobot != null) {
            try {
                controladorRobot.ejecutar(Consola.elegirComando());
            } catch (RobotExcepcion re) {
                System.out.println("ERROR: " + re.getMessage());
            }
        }
    }

}
