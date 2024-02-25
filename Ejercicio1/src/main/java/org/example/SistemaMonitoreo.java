package org.example;

import java.util.ArrayList;
import java.util.List;

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
