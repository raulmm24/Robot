package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.robot.vista.Consola;

public class Main {
    public static void main (String [] args) {
        int options = 0;
        Main main = new Main();
        while(options != 6) {
            options = Consola.elegirOpcion();
            main.ejecutarOpcion(options);
        }
    }
    private ControladorRobot controladorRobot;
    private void ejecutarOpcion(int option) {
        switch (option) {
            case 1 -> controlarRobotDefecto();
            case 2 -> controlarRobotZona();
            case 3 -> controlarRobotZonaOrientacion();
            case 4 -> controlarRobotZonaOrientaciónCoordenada();
            case 5 -> ejecutarComando();
            case 6 -> Consola.despedirse();
        }
    }
    private void controlarRobotDefecto() {
        controladorRobot = new ControladorRobot(new Robot());
    }
    private void controlarRobotZona() {
        Zona zona = Consola.elegirZona();
        controladorRobot = new ControladorRobot(new Robot(zona));
    }
    private void controlarRobotZonaOrientacion() {
        Zona zona = Consola.elegirZona();
        Orientacion orientacion = Consola.elegirOrientacion();
        controladorRobot = new ControladorRobot(new Robot(zona,orientacion));
    }
    private void controlarRobotZonaOrientaciónCoordenada() {
        Zona zona = Consola.elegirZona();
        Orientacion orientacion = Consola.elegirOrientacion();
        Coordenada coordenada = Consola.elegirCoordenada();
        controladorRobot = new ControladorRobot(new Robot(zona,orientacion,coordenada));
    }
    private void ejecutarComando() {
        if (controladorRobot != null) {
            char comando = Consola.comando();
            controladorRobot.ejecutar(comando);
        }
        Consola.mostrarRobot(controladorRobot);
    }
}
