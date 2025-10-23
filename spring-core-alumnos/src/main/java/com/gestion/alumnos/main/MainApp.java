package com.gestion.alumnos.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        
        // 1. Carga el contexto Spring desde el XML
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        // 2. Obtén los beans del contenedor
        AddAlumnoApp addApp = ctx.getBean("addApp", AddAlumnoApp.class);
        DeleteAlumnoApp deleteApp = ctx.getBean("deleteApp", DeleteAlumnoApp.class);
        ListAlumnoApp listApp = ctx.getBean("listApp", ListAlumnoApp.class);

        // 3. Ejecuta los métodos para probar el flujo 
        
        System.out.println("--- PRUEBA 1: Listar al inicio (debe estar vacío) ---");
        listApp.listarAlumnos();

        System.out.println("\n--- PRUEBA 2: Añadir alumnos ---");
        addApp.guardarAlumnos(); 

        System.out.println("\n--- PRUEBA 3: Listar después de añadir (debe mostrar 2) ---");
        listApp.listarAlumnos();
        
        System.out.println("\n--- PRUEBA 4: Borrar alumno con ID 1 ---");
        deleteApp.borrarAlumno(1); 

        System.out.println("\n--- PRUEBA 5: Listar al final (debe mostrar 1) ---");
        listApp.listarAlumnos(); 
        
        System.out.println("\n--- PRUEBA 6: Borrar alumno que no existe (ID 99) ---");
        deleteApp.borrarAlumno(99);

        // 4. Cierra el contexto de Spring
        ctx.close();
    }
}