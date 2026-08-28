package com.example.DTO_hands_on_practice_2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponseDTO> getAllUser() {

        List<User> users = userRepository.findAll();

        List<UserResponseDTO> responses = new ArrayList<>();

        for (User u : users) {
            UserResponseDTO response = userMapper.toResponse(u);
            responses.add(response);
        }

        return responses;
    }
}
