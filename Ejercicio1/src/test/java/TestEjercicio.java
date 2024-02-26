
import org.example.Ejercicio6;
import org.example.Ruta;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEjercicio {

    @Nested
    class Ejercicio1Test {

        @Test
        void testDisplayTimeOnEarth() {
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            org.example.Ejercicio1.displayTimeOnEarth(1234567890);
            String expectedOutput = "Tiempo en la Tierra:\n" +
                    "Años: 39.15185185185185\n" +
                    "Días: 14288.888888888889\n" +
                    "Horas: 342133.3333333333\n" +
                    "Minutos: 20528000.0\n" +
                    "Segundos: 1231680000.0\n";
            assertEquals(expectedOutput, outContent.toString());
        }
    }

    @Nested
    class Ejercicio2Test {

        @Test
        void testPredecirNecesidades() {
            org.example.Recurso recurso1 = new org.example.Recurso("Agua", 100, 10, 150);
            org.example.Recurso recurso2 = new org.example.Recurso("Comida", 200, 20, 300);
            org.example.GestorDeRecursos gestor = new org.example.GestorDeRecursos();
            gestor.agregarRecurso(recurso1);
            gestor.agregarRecurso(recurso2);
            List<Double> necesidades = gestor.predecirNecesidades(5);
            assertEquals(50, necesidades.get(0)); // Esperamos 50 porque el consumo proyectado de agua es 50
            assertEquals(100, necesidades.get(1)); // Esperamos 100 porque el consumo proyectado de comida es 100
        }
    }

    @Nested
    class Ejercicio3Test {

        @Test
        void testEsPrimo() {
            org.example.SistemaMonitoreo sistema = new org.example.SistemaMonitoreo();
            assertTrue(sistema.esPrimo(2)); // Esperamos true porque 2 es primo
            assertTrue(sistema.esPrimo(3)); // Esperamos true porque 3 es primo
            assertFalse(sistema.esPrimo(4)); // Esperamos false porque 4 no es primo
        }
    }


    @Nested
    class Ejercicio5Test {

        @Test
        void testPlanificarRutaOptima() {
            char[][] terreno = {

            };
            char[][] terrenoOptimo = {

            };
            assertArrayEquals(terrenoOptimo, org.example.PlanificadorRutas.planificarRutaOptima(terreno));
        }
    }



    @Nested
    class Ejercicio4Test {
        @Test
        void testAgregarPunto() {
            Ruta ruta = new Ruta(5, 5);
            ruta.agregarPunto(0, 0);
            ruta.agregarPunto(1, 1);
            ruta.agregarPunto(2, 2);
            char[][] matrizRuta = ruta.getMatrizRuta();
            assertEquals('7', matrizRuta[0][0]); // Esperamos '7' porque se agregó un punto en la posición (0, 0)
            assertEquals('7', matrizRuta[1][1]); // Esperamos '7' porque se agregó un punto en la posición (1, 1)
            assertEquals('7', matrizRuta[2][2]); // Esperamos '7' porque se agregó un punto en la posición (2, 2)
        }
    }

    @Nested
    class Ejercicio6Test {
        @Test
        void testContarVocales() {
            assertEquals(3, Ejercicio6.contarVocales("Tengo hambre")); // Esperamos 3 porque el mensaje tiene 3 vocales
        }

        @Test
        void testInvertirMensaje() {
            assertEquals("erbmah ogneT", Ejercicio6.invertirMensaje("Tengo hambre")); // Esperamos "erbmah ogneT" porque el mensaje invertido es "erbmah ogneT"
        }

        @Test
        void testEsPalindromo() {
            assertTrue(Ejercicio6.esPalindromo("Anita lava la tina")); // Esperamos true porque el mensaje es un palíndromo
        }
    }
}

