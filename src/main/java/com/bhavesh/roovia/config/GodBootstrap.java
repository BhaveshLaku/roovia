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
public class GodBootstrap implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.god.email}")
    private String godEmail;

    @Value("${app.god.password}")
    private String godPassword;

    @Override
    public void run(String... args) {
        if (userRepository.existsByEmail(godEmail)) {
            return; // already bootstrapped, do nothing
        }

        User god = new User();
        god.setName("Super Admin");
        god.setEmail(godEmail);
        god.setPassword(passwordEncoder.encode(godPassword));
        god.setRoles(Set.of(Role.GOD));

        userRepository.save(god);
        System.out.println("Bootstrap admin created: " + godEmail);
    }
}