package org.iesalandalus.programacion.robot.modelo;

public enum Orientacion {
    NORTE("Norte"),
    NORESTE("Noreste"), /* sumar tanto a x como a y*/
    ESTE("Este"), /* sumar a x */
    SURESTE("Sureste"), /*sumar la x y restar a la y */
    SUR("Sur"), /* restar a la y*/
    SUROESTE("Suroeste"), /*restar a los 2 */
    OESTE("Oeste"), /* restar a x */
    NOROESTE("Noroeste"); /* restar la x y sumar a la y*/

    private String nombre;

    Orientacion(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        String nombre = name().toLowerCase();
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
    }

}



