package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Tarea {
    String descripcion;
    int duracion; // En horas
    int prioridad;

    public Tarea(String descripcion, int duracion, int prioridad) {
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.prioridad = prioridad;
    }

    // Getters para acceder a las propiedades de la tarea
    public String getDescripcion() { return descripcion; }
    public int getDuracion() { return duracion; }
    public int getPrioridad() { return prioridad; }
}

class MiembroTripulacion {
    String nombre;
    List<Tarea> tareasAsignadas;

    public MiembroTripulacion(String nombre) {
        this.nombre = nombre;
        this.tareasAsignadas = new ArrayList<>();
    }

    public void asignarTarea(Tarea tarea) {
        tareasAsignadas.add(tarea);
    }

    public int calcularCargaTrabajo() {
        return tareasAsignadas.stream().mapToInt(Tarea::getDuracion).sum();
    }

    public String getNombre() { return nombre; }
    public List<Tarea> getTareasAsignadas() { return tareasAsignadas; }
}

class PlanificadorTareas {
    List<MiembroTripulacion> tripulacion;
    List<Tarea> tareasPendientes;

    public PlanificadorTareas() {
        tripulacion = new ArrayList<>();
        tareasPendientes = new ArrayList<>();
    }

    public void distribuirTareas() {
        Collections.sort(tareasPendientes, Comparator.comparingInt(Tarea::getPrioridad).reversed());
        for (Tarea tarea : tareasPendientes) {
            MiembroTripulacion miembro = encontrarMiembroDisponible();
            if (miembro != null) {
                miembro.asignarTarea(tarea);
            }
        }
    }

    private MiembroTripulacion encontrarMiembroDisponible() {
        return tripulacion.stream()
                .min(Comparator.comparingInt(MiembroTripulacion::calcularCargaTrabajo))
                .orElse(null);
    }

    public void agregarMiembroTripulacion(MiembroTripulacion miembro) {
        tripulacion.add(miembro);
    }

    public void agregarTarea(Tarea tarea) {
        tareasPendientes.add(tarea);
    }
}

