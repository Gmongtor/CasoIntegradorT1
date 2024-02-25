package org.example;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {
        Recurso agua = new Recurso("Agua", 1000, 150, 200);
        Recurso alimentos = new Recurso("Alimentos", 500, 50, 100);

        GestorDeRecursos gestor = new GestorDeRecursos();
        gestor.agregarRecurso(agua);
        gestor.agregarRecurso(alimentos);

        System.out.println("Consumo total diario: " + gestor.calcularConsumoTotal());
        System.out.println("Necesidades para los próximos 5 días: " + gestor.predecirNecesidades(5));
        System.out.println("Alertas: " + gestor.verificarAlertas());

        gestor.mostrarRecursos();
    }
}
