package com.example.DTO_hands_on_try;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService = new UserService();

    @PostMapping()
    public ResponseEntity<UserResponseDTO> postUser(@RequestBody UserRequestDTO dto){
        UserResponseDTO response = userService.createUser(dto);

        return new ResponseEntity<UserResponseDTO>(response,HttpStatus.OK);
    }
}
