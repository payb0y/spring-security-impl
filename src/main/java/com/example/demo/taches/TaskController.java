package com.example.demo.taches;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/task")
public class TaskController {
    private final TaskService  taskService;
    @Autowired
    public TaskController (TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO1>>  getEmployes(){
        return new  ResponseEntity<>(
                taskService.getListTasks(),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskDTO1> addTask(@RequestBody TaskDTO1 taskDTO1){
        return new ResponseEntity<>(
                taskService.addTask(taskDTO1),
                HttpStatus.CREATED);
    }

}
