package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.robot.vista.Consola;


public class Main {

    private static ControladorRobot controladorRobot;

    public static void main(String[] args) {
        int opcion;

        do {
            opcion = Consola.elegirOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 6);

    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> controlarRobotDefecto();
            case 2 -> controlarRobotZona();
            case 3 -> controlarRobotOrientacion();
            case 4 -> controlarRobotOrientacionCoordenada();
            case 5 -> ejecutarComando();
            case 6 -> Consola.despedirse();
            default -> System.out.println("Opción no valida.");
        }
    }

    private static void controlarRobotDefecto() {
        Robot robot = new Robot();
        controladorRobot = new ControladorRobot(robot);
        System.out.println("Robot creado por defecto." + robot);
    }

    private static void controlarRobotZona() {
        Zona zona = Consola.elegirZona();
        Robot robot = new Robot(zona);
        controladorRobot = new ControladorRobot(robot);
        System.out.println("Robot creado indicando su zona" + robot);
    }

    private static void controlarRobotOrientacion() {
        Zona zona = Consola.elegirZona();
        Orientacion orientacion = Consola.elegirOrientacion();
        Robot robot = new Robot(zona, orientacion);
        controladorRobot = new ControladorRobot(robot);
        System.out.println("Robot creado indicando su zona y orientación" + robot);
    }

    private static void controlarRobotOrientacionCoordenada() {
        Zona zona = Consola.elegirZona();
        Orientacion orientacion = Consola.elegirOrientacion();
        Coordenada coordenada = Consola.elegirCoordenada();
        Robot robot = new Robot(zona, orientacion, coordenada);
        controladorRobot = new ControladorRobot(robot);
        System.out.println("Robot creado indicando su zona, orientación y coordenada" + robot);
    }
    
    private static void ejecutarComando() {
        if (controladorRobot == null) {
            System.out.println("No hay ningun robot controlado actualmente. Crea uno primero.");
            return;
        }

        try {
            controladorRobot.ejecutar(Consola.elegirComando());
            System.out.println("Comando ejecutado correctamente.");
        } catch (RobotExcepcion e) {
            System.out.println("Error al ejecutar el comando" + e.getMessage());
        }
        }
    }
