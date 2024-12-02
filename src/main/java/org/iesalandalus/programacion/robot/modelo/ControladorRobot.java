package org.iesalandalus.programacion.robot.modelo;

public class ControladorRobot {

    private Robot robot;
    public ControladorRobot(Robot robot){
        if (robot != null) {
            try {
                this.robot =(Robot) robot;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new NullPointerException("El robot no puede ser nulo.");
        }
    }
    public Robot getRobot() {
        return new Robot(robot);
    }
    public void ejecutar(char comando) {
        switch (comando) {
            case 'A':
            case 'a':
                this.robot.avanzar();
            break;
            case 'D':
            case 'd':
                this.robot.girarALaDerecha();
            break;
            case 'I':
            case 'i':
                this.robot.girarALaIzquierda();
            break;
            default: throw new RobotExcepcion("Comando desconocido.");
        }
    }
}
