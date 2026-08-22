package com.example.DTO_hands_on_try;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    // post user
    public UserResponseDTO createUser(UserRequestDTO dto){
        RequestDTOtoEntity requestDTOtoEntity = new RequestDTOtoEntity();

        User user = new User();
        user = requestDTOtoEntity.convertToEntity(dto);

        EntitytoResponseDTO response = new EntitytoResponseDTO();

        return response.convertToResponse(user);
    }
}
