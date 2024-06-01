package com.example.demo.employee.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeConfig {

    //deactivate afte @PostMapping
   // @Bean
    /*CommandLineRunner commandLinerRunner(EmployeRepository repository) {
        return args -> {
            Employe ahemd= new Employe(
                    "Ahmed",
                    "ahmed@gmail.com",
                    LocalDate.of(2000, 10, 10)

            );
            Employe amina= new Employe(
                    "Amina",
                    "amina@gmail.com",
                    LocalDate.of(2004, 10, 23)
            );
            repository.saveAll(
                    List.of(ahemd,amina)
            );
        };
        }*/


}


