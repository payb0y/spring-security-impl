package com.example.demo.employee.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeDto {
    private Long id;
    private String nom;
    private String email;
   // private List<Task> taskList;
   // private List<TaskDTO> taskList;


}
