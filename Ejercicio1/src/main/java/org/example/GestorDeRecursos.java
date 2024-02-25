package org.example;

import java.util.ArrayList;
import java.util.List;

public class GestorDeRecursos {
    private List<Recurso> recursos = new ArrayList<>();

    public void agregarRecurso(Recurso recurso) {
        recursos.add(recurso);
    }

    public double calcularConsumoTotal() {
        double total = 0;
        for (Recurso recurso : recursos) {
            total += recurso.getConsumoDiarioPromedio();
        }
        return total;
    }

    public List<Double> predecirNecesidades(int dias) {
        List<Double> necesidades = new ArrayList<>();
        for (Recurso recurso : recursos) {
            double consumoProyectado = recurso.getConsumoDiarioPromedio() * dias;
            necesidades.add(consumoProyectado);
        }
        return necesidades;
    }

    public List<String> verificarAlertas() {
        List<String> alertas = new ArrayList<>();
        for (Recurso recurso : recursos) {
            if (recurso.verificarUmbral()) {
                alertas.add("Alerta: Nivel bajo en recurso " + recurso.getNombre());
            }
        }
        return alertas;
    }

    public void mostrarRecursos() {
        for (Recurso recurso : recursos) {
            System.out.println("Recurso: " + recurso.getNombre() + ", Cantidad Actual: " + recurso.getCantidadActual());
        }
    }
}
