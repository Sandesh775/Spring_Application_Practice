package com.example.DTO_hands_on_try;

import java.time.LocalDateTime;

public class RequestDTOtoEntity {

    public User convertToEntity(UserRequestDTO dto) {
        // created completely new entity
        User convertedUser = new User();

        convertedUser.setName(dto.getName());
        convertedUser.setEmail(dto.getEmail());
        convertedUser.setPassword(dto.getPassword());

        convertedUser.setRole("USER");
        convertedUser.setCreatedAt(LocalDateTime.now());

        return convertedUser;
    }
}
