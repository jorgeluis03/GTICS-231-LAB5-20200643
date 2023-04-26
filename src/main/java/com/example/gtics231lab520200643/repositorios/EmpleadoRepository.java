package com.example.gtics231lab520200643.repositorios;

import com.example.gtics231lab520200643.dto.EmpleadosDto;
import com.example.gtics231lab520200643.entity.Empelado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empelado, Integer> {
    @Query(nativeQuery = true, value = "select e.employee_id as Employee_id, e.first_name as Nombre, e.last_name Apellido, j.job_title Puesto, d.department_name as Departamento, l.city Ciudad from employees e\n" +
            "inner join jobs j  on (e.job_id = j.job_id)\n" +
            "inner join departments d on (e.department_id=d.department_id)\n" +
            "inner join locations l on (d.location_id = l.location_id)")
    List<EmpleadosDto> listaEmpelados ();


}
