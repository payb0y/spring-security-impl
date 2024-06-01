package com.example.demo.taches;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDTO {
    private String name;
    private String description;

}
