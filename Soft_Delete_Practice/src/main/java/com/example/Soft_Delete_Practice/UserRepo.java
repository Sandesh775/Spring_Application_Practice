package com.example.Soft_Delete_Practice;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByIdAndDeletedIsFalse(int id);
}
