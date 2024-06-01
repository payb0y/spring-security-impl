package com.example.demo.employee.repository;

import com.example.demo.employee.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
    @Query("Select emp from Employe emp where emp.email=?1")
    Optional<Employe> findByEmail(String email);
}
