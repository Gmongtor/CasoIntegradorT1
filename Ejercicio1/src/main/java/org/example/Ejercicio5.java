package org.example;
class Terreno {
    int[][] matrizTerreno;

    public Terreno(int filas, int columnas) {
        this.matrizTerreno = new int[filas][columnas];
    }


    public void modificarTerreno(int fila, int columna, int valor) {
        this.matrizTerreno[fila][columna] = valor;
    }


    public void visualizarTerreno() {
        for (int i = 0; i < matrizTerreno.length; i++) {
            for (int j = 0; j < matrizTerreno[i].length; j++) {
                System.out.print(matrizTerreno[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class CalculadoraMatriz {
    public static int[][] multiplicarMatrices(int[][] primeraMatriz, int[][] segundaMatriz) {
        int filasPrimera = primeraMatriz.length;
        int columnasPrimera = primeraMatriz[0].length;
        int columnasSegunda = segundaMatriz[0].length;

        int[][] resultado = new int[filasPrimera][columnasSegunda];

        for (int i = 0; i < filasPrimera; i++) {
            for (int j = 0; j < columnasSegunda; j++) {
                for (int k = 0; k < columnasPrimera; k++) {
                    resultado[i][j] += primeraMatriz[i][k] * segundaMatriz[k][j];
                }
            }
        }

        return resultado;
    }
}
class NavegadorEstelar {
    public static void main(String[] args) {
        Terreno terreno = new Terreno(5, 5);
        // Supongamos que modificamos el terreno para representar diferentes áreas
        terreno.modificarTerreno(2, 2, 1); // Ejemplo de modificación

        System.out.println("Terreno inicial:");
        terreno.visualizarTerreno();

        int[][] matrizPesos = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15}
        };

        int[][] resultado = CalculadoraMatriz.multiplicarMatrices(terreno.matrizTerreno, matrizPesos);

        System.out.println("Resultado de la optimización:");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
    }

}
