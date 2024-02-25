package org.example;

public class Recurso {
    private String nombre;
    private double cantidadActual;
    private double consumoDiarioPromedio;
    private double umbralSeguro;

    public Recurso(String nombre, double cantidadActual, double consumoDiarioPromedio, double umbralSeguro) {
        this.nombre = nombre;
        this.cantidadActual = cantidadActual;
        this.consumoDiarioPromedio = consumoDiarioPromedio;
        this.umbralSeguro = umbralSeguro;
    }

    public void consumir(double cantidad) {
        cantidadActual -= cantidad;
    }

    public void agregar(double cantidad) {
        cantidadActual += cantidad;
    }

    public boolean verificarUmbral() {
        return cantidadActual < umbralSeguro;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    public double getConsumoDiarioPromedio() {
        return consumoDiarioPromedio;
    }
}
