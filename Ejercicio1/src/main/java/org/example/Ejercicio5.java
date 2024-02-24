package org.example;
class Task {
    private String nombre;
    private int duracion;

    public void Tarea(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }
}
// Planeta.java
class Planeta {
    private static final char OBSTACULO = '1';
    private static final char TERRENO_LIBRE = '0';
    private char[][] terreno;

    public Planeta(int filas, int columnas) {
        terreno = new char[filas][columnas];
        inicializarTerreno(TERRENO_LIBRE);
    }

    private void inicializarTerreno(char valorInicial) {
        for (int i = 0; i < terreno.length; i++) {
            java.util.Arrays.fill(terreno[i], valorInicial);
        }
    }

    public void agregarObstaculo(int fila, int columna) {
        terreno[fila][columna] = OBSTACULO;
    }

    public void mostrarTerreno() {
        imprimirMatriz(terreno);
    }

    public char[][] getTerreno() {
        return terreno;
    }

    void imprimirMatriz(char[][] matriz) {
        for (char[] fila : matriz) {
            for (char c : fila) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
// Ruta.java
class Ruta {
    private static final char PUNTO_RUTA = '7';
    private char[][] matrizRuta;

    public Ruta(int filas, int columnas) {
        matrizRuta = new char[filas][columnas];
        inicializarMatrizRuta();
    }

    private void inicializarMatrizRuta() {
        for (int i = 0; i < matrizRuta.length; i++) {
            java.util.Arrays.fill(matrizRuta[i], '0');
        }
    }

    public void agregarPunto(int fila, int columna) {
        matrizRuta[fila][columna] = PUNTO_RUTA;
    }

    public void mostrarRuta() {
        imprimirMatriz(matrizRuta);
    }

    public char[][] getMatrizRuta() {
        return matrizRuta;
    }

    private void imprimirMatriz(char[][] matriz) {
        for (char[] fila : matriz) {
            for (char c : fila) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
// PlanificadorRutas.java
class PlanificadorRutas {
    public static char[][] planificarRutaOptima(char[][] terreno) {
        // Aquí se implementaría el algoritmo de planificación de rutas
        // Este código es un placeholder y debe ser reemplazado por la lógica real
        return terreno;
    }
}
// Main.java
public class Ejercicio5 {
    public static void main(String[] args) {
        Planeta planeta = new Planeta(5, 5);
        planeta.agregarObstaculo(1, 2);
        planeta.agregarObstaculo(3, 4);
        System.out.println("Terreno del planeta:");
        planeta.mostrarTerreno();

        Ruta ruta = new Ruta(5, 5);
        ruta.agregarPunto(0, 0);
        ruta.agregarPunto(1, 1);
        ruta.agregarPunto(2, 2);
        System.out.println("\nRuta planificada:");
        ruta.mostrarRuta();

        char[][] terrenoOptimo = PlanificadorRutas.planificarRutaOptima(planeta.getTerreno());
        System.out.println("\nTerreno después de planificar ruta óptima:");
        planeta.imprimirMatriz(terrenoOptimo);
    }
}

