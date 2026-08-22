package com.example.DTO_hands_on_try;

public class EntitytoResponseDTO {

    public UserResponseDTO convertToResponse(User user) {
        UserResponseDTO response = new UserResponseDTO();

        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setCreatedAt(user.getCreatedAt());

        return response;
    }
}
