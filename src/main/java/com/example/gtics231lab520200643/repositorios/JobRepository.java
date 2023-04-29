package com.example.gtics231lab520200643.repositorios;

import com.example.gtics231lab520200643.dto.ReporteDto;
import com.example.gtics231lab520200643.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
    @Query(nativeQuery = true,value = "select j.job_title as puesto,count(e.employee_id) as numempleados,max(e.salary) as salariomaximo,\n" +
            "min(e.salary) as salariominimo ,SUM(e.salary) as salariototales,truncate(avg(e.salary),2) as salariopromedio\n" +
            "from employees e\n" +
            "inner join jobs j on (e.job_id=j.job_id)\n" +
            "group by j.job_id")
    List<ReporteDto> reporteSalario ();
}
