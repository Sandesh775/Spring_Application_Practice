package com.example.SpringSecurityWithUsersDatabase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityWithUsersDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityWithUsersDatabaseApplication.class, args);
    }
// This is CommandLineRunner below is only a learning shortcut for creating the initial record.
//    @Bean
//    CommandLineRunner createUser(PasswordEncoder passwordEncoder,
//                                 UserRepository userRepository) {
//        return args -> {
//
//            User user = new User();
//
//            user.setUsername("sandesh");
//            user.setPassword(passwordEncoder.encode("1234"));
//
//            userRepository.save(user);
//        };
//
//    }
}