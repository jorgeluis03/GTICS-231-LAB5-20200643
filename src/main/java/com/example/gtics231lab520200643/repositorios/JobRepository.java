package com.example.gtics231lab520200643.repositorios;

import com.example.gtics231lab520200643.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
}
