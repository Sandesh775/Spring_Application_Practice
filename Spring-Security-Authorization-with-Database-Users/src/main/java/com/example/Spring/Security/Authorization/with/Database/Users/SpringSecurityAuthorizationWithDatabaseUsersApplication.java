package com.example.Spring.Security.Authorization.with.Database.Users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityAuthorizationWithDatabaseUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityAuthorizationWithDatabaseUsersApplication.class, args);
    }

    //@Bean
//    public CommandLineRunner createUsers(PasswordEncoder passwordEncoder, UserRepo userRepo) {
//        return args -> {
//            // Check if users already exist
//            if (userRepo.count() == 0) {
//                System.out.println("🔧 Creating initial users...");
//
//                // Create USER: sandesh
//                Users user1 = new Users();
//                user1.setUsername("sandesh");
//                user1.setPassword(passwordEncoder.encode("1234"));
//                user1.setRole("USER");
//                userRepo.save(user1);
//                System.out.println("✅ Created USER: sandesh (password: 1234)");
//
//                // Create ADMIN: admin
//                Users user2 = new Users();
//                user2.setUsername("admin");
//                user2.setPassword(passwordEncoder.encode("admin123"));
//                user2.setRole("ADMIN");
//                userRepo.save(user2);
//                System.out.println("✅ Created ADMIN: admin (password: admin123)");
//            }
//        };
}
