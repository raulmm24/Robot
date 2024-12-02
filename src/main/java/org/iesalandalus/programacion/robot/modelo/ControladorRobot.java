package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public class ControladorRobot {

    private Robot robot;

    public ControladorRobot(Robot robot){
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");
        this.robot = new Robot(robot);
    }
    public Robot getRobot() {
        return new Robot(robot);
    }

    public void ejecutar(char comando) {
        switch (comando) {
            case 'A':
            case 'a':
                robot.avanzar();
            break;
            case 'D':
            case 'd':
                robot.girarALaDerecha();
            break;
            case 'I':
            case 'i':
                robot.girarALaIzquierda();
            break;
            default: throw new RobotExcepcion("Comando desconocido.");
        }
    }
}
