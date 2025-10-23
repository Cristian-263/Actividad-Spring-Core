package com.gestion.alumnos.main;

import com.gestion.alumnos.repository.RepositorioAlumnos;

public class DeleteAlumnoApp {
	
	private final RepositorioAlumnos repositorioAlumnos;
	
	// Inyección por Constructor
	public DeleteAlumnoApp(RepositorioAlumnos repositorioAlumnos) {
        this.repositorioAlumnos = repositorioAlumnos;
    }
	public void borrarAlumno(int id) {
       boolean borrado = repositorioAlumnos.delete(id); 
        if (borrado) {
            System.out.println("Se ha borrado el alumno con id: " + id);
        } else {
            System.out.println("No se encontró alumno con id: " + id);
        }
    }

}
