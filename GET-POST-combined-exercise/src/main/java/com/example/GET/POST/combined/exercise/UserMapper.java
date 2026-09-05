package com.example.GET.POST.combined.exercise;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDTO toResponse(User u){
        UserResponseDTO response = new UserResponseDTO();

        response.setId(u.getId());
        response.setName(u.getName());
        response.setEmail(u.getEmail());
        response.setRole(u.getRole());
        response.setCreatedAt(u.getCreatedAt());

        return response;
    }

    public User toEntity(UserRequestDTO dto){
        User u = new User();

        u.setName(dto.getName());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword());

        return u;
    }
}
