package com.example.demo.employee.repository;

import com.example.demo.employee.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByToken(String token);

    Optional<Token> findByEmail(String email);

    @Query("SELECT t FROM Token t WHERE t.email = ?1")
    List<Token> getAllTokensByMail(String mail);
}
