package com.bhavesh.roovia.config;

import com.bhavesh.roovia.entity.User;
import com.bhavesh.roovia.entity.enums.Role;
import com.bhavesh.roovia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class AdminBootstrap implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.admin.email}")
    private String adminEmail;

    @Value("${app.admin.password}")
    private String adminPassword;

    @Override
    public void run(String... args) {
        if (userRepository.existsByEmail(adminEmail)) {
            return; // already bootstrapped, do nothing
        }

        User admin = new User();
        admin.setName("Super Admin");
        admin.setEmail(adminEmail);
        admin.setPassword(passwordEncoder.encode(adminPassword));
        admin.setRoles(Set.of(Role.ADMIN));

        userRepository.save(admin);
        System.out.println("Bootstrap admin created: " + adminEmail);
    }
}