package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Coordenada;
import org.iesalandalus.programacion.robot.modelo.Orientacion;
import org.iesalandalus.programacion.robot.modelo.Zona;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola() {}

    public static void mostrarMenuPrincipal() {
        System.out.println("Programa para modelar el movimiento de un robot, por una zona de la habitación, a base de comandos");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("1.- Controlar un robot por defecto.");
        System.out.println("2.- Controlar un robot definiendo la zona.");
        System.out.println("3.- Controlar un robot definiendo la zona y la orientación.");
        System.out.println("4.- Controlar un robot definiendo la zona, la orientación y su coordenada inicial.");
        System.out.println("5.- Ejecutar comando.");
        System.out.println();
        System.out.println("0.- Salir.");
        System.out.println();
    }

    public static int elegirOpcion() {
        int opcion;
        do {
            System.out.print("Elige una opción (0-5): ");
            opcion = Entrada.entero();
        } while (opcion < 0 || opcion > 5);
        return opcion;
    }

    public static Zona elegirZona() {
        Zona zona = null;
        do {
            System.out.print("Indica el ancho de la zona: ");
            int ancho = Entrada.entero();
            System.out.print("Indica el alto de la zona: ");
            int alto = Entrada.entero();
            try {
                zona = new Zona(ancho, alto);
            } catch (IllegalArgumentException iae) {
                System.out.println("ERROR: " + iae.getMessage());
            }
        } while (zona == null);
        return zona;
    }

    public static void mostrarMenuOrientacion() {
        System.out.println("Orientaciones");
        System.out.println("-------------");
        System.out.println();
        System.out.println("0.- Norte.");
        System.out.println("1.- Noreste.");
        System.out.println("2.- Este.");
        System.out.println("3.- Sureste.");
        System.out.println("4.- Sur.");
        System.out.println("5.- Suroeste.");
        System.out.println("6.- Oeste.");
        System.out.println("7.- Noroeste.");
        System.out.println();
    }

    public static Orientacion elegirOrientacion() {
        int orientacion;
        do {
            System.out.print("Elige la orientación (0 - 7): ");
            orientacion = Entrada.entero();
        } while (orientacion < 0 || orientacion > 7);
        return switch (orientacion) {
            case 0 -> Orientacion.NORTE;
            case 1 -> Orientacion.NORESTE;
            case 2 -> Orientacion.ESTE;
            case 3 -> Orientacion.SURESTE;
            case 4 -> Orientacion.SUR;
            case 5 -> Orientacion.SUROESTE;
            case 6 -> Orientacion.OESTE;
            case 7 -> Orientacion.NOROESTE;
            default -> null;
        };
    }

    public static Coordenada elegirCoordenada() {
        System.out.print("Indica la X de la coordenada: ");
        int x = Entrada.entero();
        System.out.print("Indica la Y de la coordenada: ");
        int y = Entrada.entero();
        return new Coordenada(x, y);
    }

    public static char elegirComando() {
        System.out.print("Indica el comando a ejecutar: ");
        return Entrada.caracter();
    }

    public static void mostrarRobot(ControladorRobot controladorRobot) {
        System.out.println();
        if (controladorRobot == null) {
            System.out.println("Aún no se ha creado ningún robot que controlar.");
        } else {
            System.out.println(controladorRobot.getRobot());
            System.out.println();
        }
    }

    public static void despedirse() {
        System.out.println();
        System.out.println("Hasta luego Lucas!!!!");
    }

}