package com.gestion.alumnos.main;

import com.gestion.alumnos.model.Alumno;
import com.gestion.alumnos.repository.RepositorioAlumnos;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class ListAlumnoApp {
	// Inyección por Anotación
	@Autowired
    private RepositorioAlumnos repositorioAlumnos;

    public void listarAlumnos() {
        System.out.println("--- Listado de Alumnos ---");
        List<Alumno> alumnos = repositorioAlumnos.findAll();
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            alumnos.forEach(System.out::println);
        }
        System.out.println("---------------------------");
    }

}
