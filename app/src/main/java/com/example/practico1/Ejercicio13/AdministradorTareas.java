package com.example.practico1.Ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class AdministradorTareas {
    private List<String> tareas;

    public AdministradorTareas() {
        tareas = new ArrayList<>();
    }

    public void agregarTarea(String tarea) {
        tareas.add(tarea);
    }

    public void eliminarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.remove(indice);
        }
    }

    public List<String> obtenerTareas() {
        return tareas;
    }
}


