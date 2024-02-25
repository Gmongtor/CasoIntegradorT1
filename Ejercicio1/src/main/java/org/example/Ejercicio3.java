package org.example;
import java.util.ArrayList;
import java.util.List;

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

public class SistemaMonitoreo {
    private List<FactorCritico> factoresCriticos = new ArrayList<>();

    public void agregarFactorCritico(FactorCritico factor) {
        factoresCriticos.add(factor);
    }

    public void verificarFactores() {
        for (FactorCritico factor : factoresCriticos) {
            if (factor.necesitaAjuste()) {
                System.out.println(factor.generarAlerta());
            }
        }
    }

    public void identificarEventosRaros(int n) {
        int contador = 0;
        int numero = 2;
        while (contador < n) {
            if (esPrimo(numero)) {
                System.out.println("Evento raro identificado: " + numero);
                contador++;
            }
            numero++;
        }
    }

    public boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
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
