//package com.example.expenseTraker.config;
//
////public class DataInitializer {
////}
//
//
//import com.example.expenseTraker.model.User;
//import com.example.expenseTraker.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
////import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class DataInitializer {
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Bean
//    CommandLineRunner initDatabase(UserRepository userRepository) {
//        return args -> {
//            String defaultUsername = "admin";
//
//            // 1. Check if the default user already exists
//            if (userRepository.findByUsername(defaultUsername).isEmpty()) {
//
//                // 2. Create the default user object
//                User admin = new User();
//                admin.setUsername(defaultUsername);
//                admin.setEmail("admin@expenseapp.com");
//
//                // HASH THE PASSWORD HERE
//                String rawPassword = "admin123";
//                String encodedPassword = passwordEncoder.encode(rawPassword);
//
//                admin.setPassword(encodedPassword); // Note: You should hash this in Phase 5!
//
//                // 3. Save to MySQL
//                userRepository.save(admin);
//
//                System.out.println("Default user 'admin' created successfully.");
//            } else {
//                System.out.println("Default user 'admin' already exists. Skipping initialization.");
//            }
//        };
//    }
//}