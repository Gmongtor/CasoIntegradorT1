package org.example;
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

