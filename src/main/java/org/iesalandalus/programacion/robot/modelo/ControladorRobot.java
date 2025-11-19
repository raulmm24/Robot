package org.iesalandalus.programacion.robot.modelo;

public class ControladorRobot {

    private Robot robot;

    public ControladorRobot(Robot robot) {
        if (robot == null) {
            throw new NullPointerException("El robot no puede ser nulo.");
        }
        this.robot = new Robot();
    }

    public Robot getRobot() {
        return new Robot();
    }

    public void ejecutar(char comando) {

        switch (Character.toUpperCase(comando)) {

            case 'A' -> robot.avanzar();

            case 'D' -> robot.girarALaDerecha();

            case 'I' -> robot.girarALaIzquierda();

            default -> throw new RobotExcepcion("Comando desconocido.");
        }
    }
}
