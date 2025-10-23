package com.gestion.alumnos.main;

import com.gestion.alumnos.model.Alumno;
import com.gestion.alumnos.repository.RepositorioAlumnos;

public class AddAlumnoApp {
	
	private RepositorioAlumnos repositorioAlumnos;

	// Inyección por Setter
	public void setRepositorioAlumnos(RepositorioAlumnos repositorioAlumnos) {
        this.repositorioAlumnos = repositorioAlumnos;
    }

	public void guardarAlumnos() {
        Alumno alu1 = new Alumno(1, "Juan Perez", "juan@mail.com");
        Alumno alu2 = new Alumno(2, "Maria Lopez", "maria@mail.com");
        
        repositorioAlumnos.add(alu1);
        System.out.println("Confirmación: Alumno añadido -> " + alu1.getNombre());

        repositorioAlumnos.add(alu2);
        System.out.println("Confirmación: Alumno añadido -> " + alu2.getNombre());
    }
}
