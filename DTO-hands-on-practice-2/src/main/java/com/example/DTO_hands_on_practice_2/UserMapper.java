package com.example.DTO_hands_on_practice_2;

public class UserMapper {
    // User Entity → UserResponseDTO
    public UserResponseDTO toResponse(User user) {
        // manually map fields
        UserResponseDTO response = new UserResponseDTO();

        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setName(user.getName());
        response.setRole(user.getRole());
        response.setCreatedAt(user.getCreatedAt());

        return response;
    }
}