package com.example.demo.taches;

import com.example.demo.employee.dto.EmployeDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TaskDTO1 {
    private Long id;
    private String name;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private EmployeDto employe;





}
