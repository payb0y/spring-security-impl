package com.example.demo;


import com.example.demo.employee.entity.Employe;
import com.example.demo.employee.entity.Role;
import com.example.demo.employee.repository.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {

    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLinerRunner(EmployeRepository repository) {
        return _ -> {
            Employe a = Employe.builder()
                    .nom("Ahmed1")
                    .email("test1@gmail.com")
                    .password(passwordEncoder.encode("1234"))
                    .role(Role.ADMIN)
                    .build();
            Employe b = Employe.builder()
                    .nom("Ahmed2")
                    .email("test2@gmail.com")
                    .password(passwordEncoder.encode("1234"))
                    .role(Role.USER)
                    .build();
            repository.saveAll(
                    List.of(a, b)
            );
        };
    }
}
