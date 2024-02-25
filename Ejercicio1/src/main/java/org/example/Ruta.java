package org.example;

// Ruta.java
public class Ruta {
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
