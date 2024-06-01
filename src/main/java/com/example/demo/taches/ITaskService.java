package com.example.demo.taches;

import java.util.List;

public interface ITaskService {

    public List<TaskDTO1> getListTasks();
    public TaskDTO getTaskById(Long id);
    public TaskDTO1 addTask(TaskDTO1 taskDTO1);
    public void deleteTask(Long id);
    public TaskDTO editTask(TaskDTO taskDTO);
    public List<TaskDTO> getListTasksByEmploye(Long id);



   // add
    // delete
    //

}
