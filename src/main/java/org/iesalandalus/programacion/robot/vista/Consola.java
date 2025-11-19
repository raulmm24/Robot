package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Coordenada;
import org.iesalandalus.programacion.robot.modelo.Orientacion;
import org.iesalandalus.programacion.robot.modelo.Zona;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola() {}

    public static void mostrarMenuPrincipal() {
        System.out.println(" Menu Principal ");
        System.out.println("1. - Controlar un robot por defecto.");
        System.out.println("2. - Controlar un robot indicando su zona.");
        System.out.println("3. - Controlar un robot indicando su zona y orientación.");
        System.out.println("4. - Controlar un robot indicando su zona, orientación y coordenada inicial.");
        System.out.println("5. - Ejecutar un comando.");
        System.out.println("6. - Salir");

    }

    public static int elegirOpcion() {
        mostrarMenuPrincipal();
        int opcion;
        do {
            System.out.println("Elija una opción (1-6)");
            opcion = Entrada.entero();
        } while (opcion < 0 || opcion > 6);

        return opcion;
    }

    public static Zona elegirZona() {
        Zona zona = null;
        int ancho;
        int alto;
        
        do {
            try {
                System.out.println("Introduce el ancho de la zona:");
                ancho = Entrada.entero();

                System.out.println("Introduce el alto de la zona:");
                alto = Entrada.entero();

                zona = new Zona(ancho, alto);
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la zona" + e.getMessage() + "Intentalo de nuevo.");
            }
        } while (zona == null);

        return zona;
    }

    public static void mostrarMenuOrientacion() {
        System.out.println(" Menu de Orientación ");
        System.out.println("1. - Norte");
        System.out.println("2. - Noreste");
        System.out.println("3. - Este");
        System.out.println("4. - Sureste");
        System.out.println("5. - Sur");
        System.out.println("6. - Suroeste");
        System.out.println("7. - Oeste");
        System.out.println("8. - Noroeste");
    }

    public static Orientacion elegirOrientacion() {
        Orientacion orientacion = null;
        int opcion;

        do {
            mostrarMenuOrientacion();
            System.out.println("Elija una orientación (1-8)");
            opcion = Entrada.entero();

            switch (opcion) {
                case 1 -> orientacion = Orientacion.NORTE;
                case 2 -> orientacion = Orientacion.NORESTE;
                case 3 -> orientacion = Orientacion.ESTE;
                case 4 -> orientacion = Orientacion.SURESTE;
                case 5 -> orientacion = Orientacion.SUR;
                case 6 -> orientacion = Orientacion.SUROESTE;
                case 7 -> orientacion = Orientacion.OESTE;
                case 8 -> orientacion = Orientacion.NOROESTE;
                default -> System.out.println("Opción no valida. Intentalo de nuevo.");
            }
        } while (orientacion == null);

        return orientacion;
    }

    public static Coordenada elegirCoordenada() {
        int x;
        int y;
        Coordenada coordenada = null;

        do {
            try {
                System.out.println("Introduce la coordenada X:");
                x = Entrada.entero();

                System.out.println("Introduce la coordenada Y:");
                y = Entrada.entero();

                coordenada = new Coordenada(x, y);

            } catch (IllegalArgumentException e) {
                System.out.println("Coordenada invalida" + e.getMessage() + " , Vuelve a intentarlo.");
            }

        } while (coordenada == null);

        return coordenada;
    }

    public static char elegirComando() {
        char comando = ' ';

        System.out.println("Introduce el comando a ejecutar:");
        comando = Entrada.caracter();

        return comando;
    }

    public static void mostrarRobot(ControladorRobot controladorRobot) {
        if (controladorRobot == null) {
            throw new IllegalArgumentException("No existe ningún robot para mostrar.");
        } else {
            System.out.println(controladorRobot);
        }
    }

    public static void despedirse() {
        System.out.println("Hasta luego Lucas !!");
    }
}