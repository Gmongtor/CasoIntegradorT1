package org.example;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
    public static void main(String[] args) {
        SistemaMonitoreo sistema = new SistemaMonitoreo();

        sistema.agregarFactorCritico(new FactorCritico("Radiación", 30, 10, 20, "Ajustar escudos de radiación."));
        sistema.agregarFactorCritico(new FactorCritico("Temperatura", 22, 18, 26, "Ajustar sistema de climatización."));
        sistema.agregarFactorCritico(new FactorCritico("Presión", 101, 95, 105, "Verificar sellado de la estación."));

        sistema.verificarFactores();
        sistema.identificarEventosRaros(5);
    }
}
