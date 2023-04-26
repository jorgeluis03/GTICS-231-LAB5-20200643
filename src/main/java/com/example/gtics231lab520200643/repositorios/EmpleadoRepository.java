package com.example.gtics231lab520200643.repositorios;

import com.example.gtics231lab520200643.entity.Empelado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empelado, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM employees\n" +
            "where first_name = ?1 or \n" +
            "\tlast_name = ?2 ")
    List<Empelado> buscar (String nombre, String apellido);


}
