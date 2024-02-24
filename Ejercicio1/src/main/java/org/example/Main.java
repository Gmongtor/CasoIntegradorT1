package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public class Ejercicio1 {
        private static final double EARTH_SECONDS_IN_YEAR = 31557600;

        public static void main(String[] args) {

            double earthTimeInSeconds = 1234567890;
            displayTimeOnEarth(earthTimeInSeconds);


            String planetName = "Nuevo Planeta";
            double conversionFactor = 1.5;
            displayTimeOnPlanet(earthTimeInSeconds, planetName, conversionFactor);

            displayMaxValues();
        }

        private static void displayTimeOnEarth(double timeInSeconds) {
            double years = timeInSeconds / EARTH_SECONDS_IN_YEAR;
            double days = years * 365;
            double hours = days * 24;
            double minutes = hours * 60;
            double seconds = minutes * 60;

            System.out.println("Tiempo en la Tierra:");
            System.out.println("Años: " + years);
            System.out.println("Días: " + days);
            System.out.println("Horas: " + hours);
            System.out.println("Minutos: " + minutes);
            System.out.println("Segundos: " + seconds);
        }

        private static void displayTimeOnPlanet(double timeInSeconds, String planetName, double conversionFactor) {
            double planetTimeInSeconds = timeInSeconds / conversionFactor;
            double planetYears = planetTimeInSeconds / EARTH_SECONDS_IN_YEAR;
            double planetDays = planetYears * 365;
            double planetHours = planetDays * 24;
            double planetMinutes = planetHours * 60;
            double planetSeconds = planetMinutes * 60;

            System.out.println("Tiempo en " + planetName + ":");
            System.out.println("Años: " + planetYears);
            System.out.println("Días: " + planetDays);
            System.out.println("Horas: " + planetHours);
            System.out.println("Minutos: " + planetMinutes);
            System.out.println("Segundos: " + planetSeconds);
        }

        private static void displayMaxValues() {
            System.out.println("Valor máximo:");

            System.out.println("Byte: " + Byte.MAX_VALUE);
            System.out.println("Short: " + Short.MAX_VALUE);
            System.out.println("Integer: " + Integer.MAX_VALUE);
            System.out.println("Long: " + Long.MAX_VALUE);
            System.out.println("Float: " + Float.MAX_VALUE);
            System.out.println("Double: " + Double.MAX_VALUE);
        }
    }
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
        private List<org.example.Recurso> recursos = new ArrayList<>();

        public void agregarRecurso(org.example.Recurso recurso) {
            recursos.add(recurso);
        }

        public double calcularConsumoTotal() {
            double total = 0;
            for (org.example.Recurso recurso : recursos) {
                total += recurso.getConsumoDiarioPromedio();
            }
            return total;
        }

        public List<Double> predecirNecesidades(int dias) {
            List<Double> necesidades = new ArrayList<>();
            for (org.example.Recurso recurso : recursos) {
                double consumoProyectado = recurso.getConsumoDiarioPromedio() * dias;
                necesidades.add(consumoProyectado);
            }
            return necesidades;
        }

        public List<String> verificarAlertas() {
            List<String> alertas = new ArrayList<>();
            for (org.example.Recurso recurso : recursos) {
                if (recurso.verificarUmbral()) {
                    alertas.add("Alerta: Nivel bajo en recurso " + recurso.getNombre());
                }
            }
            return alertas;
        }

        public void mostrarRecursos() {
            for (org.example.Recurso recurso : recursos) {
                System.out.println("Recurso: " + recurso.getNombre() + ", Cantidad Actual: " + recurso.getCantidadActual());
            }
        }
    }
    public class Ejercicio2 {
        public static void main(String[] args) {
            org.example.Recurso agua = new org.example.Recurso("Agua", 1000, 150, 200);
            org.example.Recurso alimentos = new org.example.Recurso("Alimentos", 500, 50, 100);

            org.example.GestorDeRecursos gestor = new org.example.GestorDeRecursos();
            gestor.agregarRecurso(agua);
            gestor.agregarRecurso(alimentos);

            System.out.println("Consumo total diario: " + gestor.calcularConsumoTotal());
            System.out.println("Necesidades para los próximos 5 días: " + gestor.predecirNecesidades(5));
            System.out.println("Alertas: " + gestor.verificarAlertas());

            gestor.mostrarRecursos();
        }
    }
    class FactorCritico {
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

    class SistemaMonitoreo {
        private List<org.example.FactorCritico> factoresCriticos = new ArrayList<>();

        public void agregarFactorCritico(org.example.FactorCritico factor) {
            factoresCriticos.add(factor);
        }

        public void verificarFactores() {
            for (org.example.FactorCritico factor : factoresCriticos) {
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

        private boolean esPrimo(int numero) {
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
            org.example.SistemaMonitoreo sistema = new org.example.SistemaMonitoreo();

            sistema.agregarFactorCritico(new org.example.FactorCritico("Radiación", 30, 10, 20, "Ajustar escudos de radiación."));
            sistema.agregarFactorCritico(new org.example.FactorCritico("Temperatura", 22, 18, 26, "Ajustar sistema de climatización."));
            sistema.agregarFactorCritico(new org.example.FactorCritico("Presión", 101, 95, 105, "Verificar sellado de la estación."));

            sistema.verificarFactores();
            sistema.identificarEventosRaros(5);
        }
    }

    class Tarea {
        String nombre;
        int cargaTrabajo;

        public Tarea(String nombre, int cargaTrabajo) {
            this.nombre = nombre;
            this.cargaTrabajo = cargaTrabajo;
        }

        // Getters y Setters
        public String getNombre() {
            return nombre;
        }

        public int getCargaTrabajo() {
            return cargaTrabajo;
        }
    }
    class MiembroDeTripulacion {
        String nombre;
        double[] habilidades;

        public MiembroDeTripulacion(String nombre, double[] habilidades) {
            this.nombre = nombre;
            this.habilidades = habilidades;
        }

        // Getters y Setters
        public String getNombre() {
            return nombre;
        }

        public double[] getHabilidades() {
            return habilidades;
        }
    }


    class PlanificadorDeTareas {
        List<org.example.Tarea> tareas = new ArrayList<>();
        List<org.example.MiembroDeTripulacion> tripulacion = new ArrayList<>();

        public void agregarTarea(org.example.Tarea tarea) {
            tareas.add(tarea);
        }

        public void agregarMiembroDeTripulacion(org.example.MiembroDeTripulacion miembro) {
            tripulacion.add(miembro);
        }

        public void asignarTareas() {

            for (org.example.Tarea tarea : tareas) {
                org.example.MiembroDeTripulacion mejorCandidato = null;
                double mejorHabilidad = 0;
                for (org.example.MiembroDeTripulacion miembro : tripulacion) {
                    double habilidad = miembro.getHabilidades()[tareas.indexOf(tarea)]; // Suponiendo orden correspondiente
                    if (habilidad > mejorHabilidad) {
                        mejorHabilidad = habilidad;
                        mejorCandidato = miembro;
                    }
                }
                System.out.println("La tarea " + tarea.getNombre() + " es asignada a " + (mejorCandidato != null ? mejorCandidato.getNombre() : "nadie"));
            }
        }

        public static void main(String[] args) {
            org.example.PlanificadorDeTareas planificador = new org.example.PlanificadorDeTareas();

            planificador.agregarTarea(new org.example.Tarea("Navegación", 2));
            planificador.agregarTarea(new org.example.Tarea("Mantenimiento", 3));
            planificador.agregarMiembroDeTripulacion(new org.example.MiembroDeTripulacion("Alice", new double[]{0.8, 0.5}));
            planificador.agregarMiembroDeTripulacion(new org.example.MiembroDeTripulacion("Bob", new double[]{0.9, 0.8}));

            planificador.asignarTareas();
        }
    }
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
            org.example.Planeta planeta = new org.example.Planeta(5, 5);
            planeta.agregarObstaculo(1, 2);
            planeta.agregarObstaculo(3, 4);
            System.out.println("Terreno del planeta:");
            planeta.mostrarTerreno();

            org.example.Ruta ruta = new org.example.Ruta(5, 5);
            ruta.agregarPunto(0, 0);
            ruta.agregarPunto(1, 1);
            ruta.agregarPunto(2, 2);
            System.out.println("\nRuta planificada:");
            ruta.mostrarRuta();

            char[][] terrenoOptimo = org.example.PlanificadorRutas.planificarRutaOptima(planeta.getTerreno());
            System.out.println("\nTerreno después de planificar ruta óptima:");
            planeta.imprimirMatriz(terrenoOptimo);
        }
    }
    class ComunicadorInterplanetario {

        // Función para contar vocales en un mensaje
        public static int contarVocales(String mensaje) {
            int contadorVocales = 0;
            String vocales = "aeiouAEIOU";
            for (int i = 0; i < mensaje.length(); i++) {
                if (vocales.indexOf(mensaje.charAt(i)) != -1) {
                    contadorVocales++;
                }
            }
            return contadorVocales;
        }

        // Función para invertir un mensaje
        public static String invertirMensaje(String mensaje) {
            return new StringBuilder(mensaje).reverse().toString();
        }

        // Función para verificar si un mensaje es un palíndromo
        public static boolean esPalindromo(String mensaje) {
            String mensajeLimpio = mensaje.replaceAll("\\s+", "").toLowerCase();
            return mensajeLimpio.equals(new StringBuilder(mensajeLimpio).reverse().toString());
        }

        public static void main(String[] args) {
            String mensaje = "Tengo hambre";

            // Contar vocales
            int vocales = contarVocales(mensaje);
            System.out.println("El mensaje tiene " + vocales + " vocales.");

            // Invertir mensaje
            String mensajeInvertido = invertirMensaje(mensaje);
            System.out.println("Mensaje invertido: " + mensajeInvertido);

            // Verificar si es palíndromo
            boolean esPalindromo = esPalindromo(mensaje);
            System.out.println("¿El mensaje es un palíndromo? " + esPalindromo);
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}