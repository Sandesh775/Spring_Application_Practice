package com.example.Spring.Security.Intro;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepo taskRepo;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepo taskRepo, TaskMapper taskMapper) {
        this.taskRepo = taskRepo;
        this.taskMapper = taskMapper;
    }


    public List<TaskResponseDTO> getAllTask(){

        List<Task> tasks = taskRepo.findAll();

        List<TaskResponseDTO> responses = new ArrayList<>();

        for(Task t : tasks){

            TaskResponseDTO task = taskMapper.toResponse(t);

            responses.add(task);
        }
        return responses;
    }

    public TaskResponseDTO createTask(TaskRequestDTO dto){

        Task task = taskMapper.toEntity(dto);

        Task savedTask = taskRepo.save(task);

        return taskMapper.toResponse(savedTask);
    }
}
