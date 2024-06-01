package com.example.demo.taches;

import com.example.demo.employee.dto.EmployeMapper;

public class TaskMapper {
    public static TaskDTO convertEnityToDto(Task tache){
        return  TaskDTO.builder()
                .description(tache.getDescription())
                .name(tache.getName())
                .build();
    }

    public static Task convertDtoToEnity(TaskDTO taskDTO){
        return  Task.builder()
                .description(taskDTO.getDescription())
                .name(taskDTO.getName())
                .build();
    }

    public static Task convertDtoToEnityAll(TaskDTO1 taskDTO1){
        return  Task.builder()
                .description(taskDTO1.getDescription())
                .name(taskDTO1.getName())
                .dateDebut(taskDTO1.getDateDebut())
                .dateFin(taskDTO1.getDateFin())
                .employe(EmployeMapper.convertDtoToEntity(taskDTO1.getEmploye()))
                .build();
    }

    public static TaskDTO1 convertEnityToDtoAll(Task tache){
        return  TaskDTO1.builder()
                .description(tache.getDescription())
                .name(tache.getName())
                .dateDebut(tache.getDateDebut())
                .dateFin(tache.getDateFin())
                .employe(EmployeMapper.convertEntityToDto(tache.getEmploye()))
                .build();


    }
}
