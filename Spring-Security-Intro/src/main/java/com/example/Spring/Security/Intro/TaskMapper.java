package com.example.Spring.Security.Intro;

import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task toEntity(TaskRequestDTO dto){
        Task t = new Task();

        t.setTitle(dto.getTitle());
        t.setDescritpion(dto.getDescritpion());
        t.setStatus(dto.isStatus());

        return t;
    }

    public TaskResponseDTO toResponse(Task t){
        TaskResponseDTO dto = new TaskResponseDTO();

        dto.setId(t.getId());
        dto.setTitle(t.getTitle());
        dto.setCreatedAt(t.getCreatedAt());
        dto.setStatus(t.isStatus());
        dto.setUpdatedAt(t.getUpdatedAt());
        dto.setDescritpion(t.getDescritpion());

        return dto;
    }
}
