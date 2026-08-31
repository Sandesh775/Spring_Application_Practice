package com.example.GET.POST.combined.exercise;


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

    public UserResponseDTO createUser(UserRequestDTO dto){
        User user = userMapper.toEntity(dto);

        User savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }
}
