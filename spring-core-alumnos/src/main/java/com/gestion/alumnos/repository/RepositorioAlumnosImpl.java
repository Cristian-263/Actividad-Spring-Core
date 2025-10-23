package com.gestion.alumnos.repository;

	import com.gestion.alumnos.model.Alumno;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.stream.Collectors;

	public class RepositorioAlumnosImpl implements RepositorioAlumnos {

	    private List<Alumno> listaAlumnos = new ArrayList<>();

	    @Override
	    public void add(Alumno a) {
	        listaAlumnos.add(a);
	    }

	    @Override
	    public boolean delete(int id) {
	        return listaAlumnos.removeIf(alumno -> alumno.getId() == id);
	    }

	    @Override
	    public List<Alumno> findAll() {
	        return new ArrayList<>(listaAlumnos); // Devuelve una copia
	    }
	}


