package com.example.demo.taches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService implements ITaskService {


    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    /*@Override
    public List<TaskDTO> getListTasks() {
         return taskRepository.findAll()
                 .stream()
                 .map(TaskMapper::convertEnityToDto)
                 .collect(Collectors.toList());

    }*/

    @Override
    public List<TaskDTO1> getListTasks() {
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::convertEnityToDtoAll)
                .collect(Collectors.toList());

    }

    public TaskDTO1 addTask(TaskDTO1 taskDTO1) {
        Task tache= TaskMapper.convertDtoToEnityAll(taskDTO1);
        return TaskMapper.convertEnityToDtoAll(taskRepository.save(tache));
    }


    @Override
    public TaskDTO getTaskById(Long id) {
        return null;
    }



    @Override
    public void deleteTask(Long id) {

    }

    @Override
    public TaskDTO editTask(TaskDTO taskDTO) {
        return null;
    }

    @Override
    public List<TaskDTO> getListTasksByEmploye(Long id) {
        return List.of();
    }
}
