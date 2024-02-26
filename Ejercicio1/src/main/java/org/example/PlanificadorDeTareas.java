package org.example;

import java.util.ArrayList;
import java.util.List;

public class PlanificadorDeTareas {
    List<Tarea> tareas = new ArrayList<>();
    List<MiembroDeTripulacion> tripulacion = new ArrayList<>();

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void agregarMiembroDeTripulacion(MiembroDeTripulacion miembro) {
        tripulacion.add(miembro);
    }

    public void asignarTareas() {

        for (Tarea tarea : tareas) {
            MiembroDeTripulacion mejorCandidato = null;
            double mejorHabilidad = 0;
            for (MiembroDeTripulacion miembro : tripulacion) {
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
        PlanificadorDeTareas planificador = new PlanificadorDeTareas();

        planificador.agregarTarea(new Tarea("Navegación", 2));
        planificador.agregarTarea(new Tarea("Mantenimiento", 3));
        planificador.agregarMiembroDeTripulacion(new MiembroDeTripulacion("Alice", new double[]{0.8, 0.5}));
        planificador.agregarMiembroDeTripulacion(new MiembroDeTripulacion("Bob", new double[]{0.9, 0.8}));

        planificador.asignarTareas();
    }
}
