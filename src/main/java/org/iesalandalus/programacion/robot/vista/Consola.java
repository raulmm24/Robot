package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.*;

import java.util.Scanner;

public class Consola {
    private Consola() {
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("Menu Principal");
        System.out.println("Opción 1: Controlar robot por defecto");
        System.out.println("Opción 2: Indicando su zona");
        System.out.println("Opción 3: Indicando su zona y orientación");
        System.out.println("Opción 4: orientación y Indicando su zona, orientación y coordenada incial");
        System.out.println("Opción 5: Ejecutar comando y salir");
    }

    public static int elegirOpcion() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        mostrarMenuPrincipal();
        while (option <= 0 || option > 5) {
            System.out.println("Elegir una de las opciones");
            option = scanner.nextInt();
        }
        return option;
    }

    public static Zona elegirZona() {
        Scanner scanner = new Scanner(System.in);
        int ancho = 0;
        int alto = 0;
        Zona correcta = null;
        System.out.println("Crear Zona");

        while (correcta == null) {
            System.out.println("Dame el ancho");
            ancho = scanner.nextInt();
            System.out.println("Dame el alto");
            alto = scanner.nextInt();
            try {
                correcta = new Zona(ancho, alto);
            } catch (IllegalArgumentException e) {
                correcta = null;
            }
        }
        return correcta;
    }

    public static void mostrarMenuOrientacion() {
        System.out.println("Menu Orientación");
        System.out.println("Opción 1: NORTE");
        System.out.println("Opción 2: NORESTE");
        System.out.println("Opción 3: ESTE");
        System.out.println("Opción 4: SURESTE");
        System.out.println("Opción 5: SUR");
        System.out.println("Opción 6: SUROESTE");
        System.out.println("Opción 7: OESTE");
        System.out.println("Opción 8: NOROESTE");
    }

    public static Orientacion elegirOrientacion() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        mostrarMenuOrientacion();
        while (option <= 0 || option > 8) {
            System.out.println("Elegir una de las opciones");
            option = scanner.nextInt();
        }
        Orientacion orientacion = Orientacion.NORTE;
        switch (option) {
            case 1 -> orientacion = Orientacion.NORTE;
            case 2 -> orientacion = Orientacion.NORESTE;
            case 3 -> orientacion = Orientacion.ESTE;
            case 4 -> orientacion = Orientacion.SURESTE;
            case 5 -> orientacion = Orientacion.SUR;
            case 6 -> orientacion = Orientacion.SUROESTE;
            case 7 -> orientacion = Orientacion.OESTE;
            case 8 -> orientacion = Orientacion.NOROESTE;
        }
        return orientacion;
    }

    public static Coordenada elegirCoordenada() {
        Scanner scanner = new Scanner(System.in);
        int x = -1;
        int y = -1;
        System.out.println("Devuelve una coordenada");
        while (x < 0 && y < 0) {
            System.out.println("Dame la x");
            x = scanner.nextInt();
            System.out.println("Dame la y");
            y = scanner.nextInt();
        }
        return new Coordenada(x, y);
    }

    public static char comando() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elija un comando a ejecutar");

        System.out.println("A: Avanzar");
        System.out.println("D: Girar a la derecha");
        System.out.println("I: Girar a la izquierda");
        System.out.println("Ingrese el comando");

        String input = scanner.nextLine();
        if (input.length() == 1) {
            return input.charAt(0);
        } else {
            System.out.println("Entrada invalida. Por favor ingrese un solo carácter");
        }
        return comando();
    }

    public static void mostrarRobot (ControladorRobot controladorRobot){
        if (controladorRobot == null) {
            System.out.println("El controlador es nulo.");
        } else if (controladorRobot.getRobot() == null) {
            System.out.println("El robot dentro del controlador es nulo.");
        } else {
            System.out.println("Parametros del robot" + controladorRobot.getRobot());
            }
        }

        public static void despedirse() {
            System.out.println("Hasta Luego!!");
        }
    }

