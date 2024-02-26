package org.example;

public class MiembroDeTripulacion {
    String nombre;
    double[] habilidades;

    public MiembroDeTripulacion(String nombre, double[] habilidades) {
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public double[] getHabilidades() {
        return habilidades;
    }
}
