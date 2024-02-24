package org.example;

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

