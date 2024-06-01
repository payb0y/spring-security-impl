package com.example.demo.employee.dto;

import com.example.demo.employee.entity.Employe;

public  class EmployeMapper {

    public static EmployeDto convertEntityToDto(Employe emp){
        return  EmployeDto.builder()
                .id(emp.getId())
                .email(emp.getEmail())
                .nom(emp.getNom())
                //.taskList(emp.getTaskList())
              /*  .taskList(emp.getTaskList()
                        .stream()
                        .map(TaskMapper::convertEnityToDto)
                        .collect(Collectors.toList()))*/
                .build();
    }
    public static Employe convertDtoToEntity(EmployeDto empDto){

        return  Employe.builder()
                .id(empDto.getId())
                .email(empDto.getEmail())
                .nom(empDto.getNom())
                //.taskList(empDto.getTaskList())
                .build();
    }
}
