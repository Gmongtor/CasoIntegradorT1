package org.example;

public class FactorCritico {
    private String nombre;
    private double valorActual;
    private double valorMinimo;
    private double valorMaximo;
    private String sugerenciaAjuste;

    public FactorCritico(String nombre, double valorActual, double valorMinimo, double valorMaximo, String sugerenciaAjuste) {
        this.nombre = nombre;
        this.valorActual = valorActual;
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
        this.sugerenciaAjuste = sugerenciaAjuste;
    }

    public boolean necesitaAjuste() {
        return valorActual < valorMinimo || valorActual > valorMaximo;
    }

    public String generarAlerta() {
        if (valorActual < valorMinimo) {
            return "ALERTA: " + nombre + " por debajo del mínimo. " + sugerenciaAjuste;
        } else if (valorActual > valorMaximo) {
            return "ALERTA: " + nombre + " por encima del máximo. " + sugerenciaAjuste;
        } else {
            return nombre + " dentro de parámetros normales.";
        }
    }

}
