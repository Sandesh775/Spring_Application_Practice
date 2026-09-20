package com.example.Delete_Method_Request_Practice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // delete method
    public ResponseEntity<String> deleteMethod(int id){
        if(!userRepo.existsById(id)){
            throw new UserNotFoundException("user not found !");
        }
        userRepo.deleteById(id);
        return ResponseEntity.ok("User deleted successfully !");
    }
}
