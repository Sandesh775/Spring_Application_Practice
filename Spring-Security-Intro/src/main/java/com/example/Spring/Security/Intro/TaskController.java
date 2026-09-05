package com.example.Spring.Security.Intro;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTask(){

        List<TaskResponseDTO> responseDTOS = taskService.getAllTask();

        return ResponseEntity.ok(responseDTOS);
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO dto){

        TaskResponseDTO response = taskService.createTask(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
