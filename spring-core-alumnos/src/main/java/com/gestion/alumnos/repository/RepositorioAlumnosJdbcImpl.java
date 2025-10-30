package com.gestion.alumnos.repository;
import com.gestion.alumnos.model.Alumno;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RepositorioAlumnosJdbcImpl implements RepositorioAlumnos {
	private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
 // Inyectamos el DataSource a través de un setter
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void add(Alumno a) {
        String query = "INSERT INTO Alumno (id, nombre, email) VALUES (?, ?, ?)";
        Object[] args = new Object[] { a.getId(), a.getNombre(), a.getEmail() };
        
        int out = jdbcTemplate.update(query, args);
        if (out != 0) {
            System.out.println("JDBC: Alumno añadido con id=" + a.getId());
        } else {
            System.out.println("JDBC: Error al añadir alumno con id=" + a.getId());
        }
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM Alumno WHERE id = ?";
        int out = jdbcTemplate.update(query, id);
        
        if (out != 0) {
            System.out.println("JDBC: Alumno borrado con id=" + id);
            return true;
        } else {
            System.out.println("JDBC: No se encontró alumno para borrar con id=" + id);
            return false;
        }
    }

    @Override
    public List<Alumno> findAll() {
        String query = "SELECT * FROM Alumno";
        List<Alumno> alumnos = new ArrayList<>();

        // queryForList devuelve una lista de mapas (uno por cada fila)
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        
        for (Map<String, Object> row : rows) {
            Alumno alu = new Alumno();
            alu.setId((Integer) (row.get("id")));
            alu.setNombre((String) row.get("nombre"));
            alu.setEmail((String) row.get("email"));
            alumnos.add(alu);
        }
        
        return alumnos;
    }
}
