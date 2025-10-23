package com.gestion.alumnos.repository;

import java.util.List;
import java.util.Optional;
import com.gestion.alumnos.model.Alumno;

public interface RepositorioAlumnos {

	public void add(Alumno a); 
	public boolean delete(int id); 
	public List<Alumno> findAll(); 
}