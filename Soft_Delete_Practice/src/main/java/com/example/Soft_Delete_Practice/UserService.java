package com.example.Soft_Delete_Practice;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Boolean softDelete(int id ){
        Optional<User> existingUser = userRepo.findByIdAndDeletedIsFalse(id);

        if(existingUser.isEmpty()){
            return false;
        }

        User userToSave = existingUser.get();

        userToSave.setDeleted(true);

        userRepo.save(userToSave);

        return true;
    }
}
