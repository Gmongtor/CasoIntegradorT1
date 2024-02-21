package org.example;
import java.util.ArrayList;
import java.util.List;
class Recurso {
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

class GestorDeRecursos {
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
