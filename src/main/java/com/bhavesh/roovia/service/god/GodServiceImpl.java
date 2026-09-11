package com.bhavesh.roovia.service.god;

import com.bhavesh.roovia.dto.god.UserSummaryDto;
import com.bhavesh.roovia.entity.User;
import com.bhavesh.roovia.entity.enums.Role;
import com.bhavesh.roovia.exception.InvalidOperationException;
import com.bhavesh.roovia.exception.ResourceNotFoundException;
import com.bhavesh.roovia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GodServiceImpl implements GodService{

    private final UserRepository userRepository;

    @Transactional
    public UserSummaryDto updateRoles(Long targetUserId, Set<Role> newRoles, Authentication actingAdmin) {

        if (newRoles == null || newRoles.isEmpty()) {
            throw new InvalidOperationException("Roles set cannot be empty");
        }

        User target = userRepository.findById(targetUserId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + targetUserId));

        // Prevent an admin from removing their own ADMIN role (avoids locking everyone out)
        boolean isSelf = target.getEmail().equalsIgnoreCase(actingAdmin.getName());
        if (isSelf && !newRoles.contains(Role.ADMIN)) {
            throw new InvalidOperationException("You cannot remove your own ADMIN role");
        }

        target.setRoles(newRoles);
        User saved = userRepository.save(target);

        return toSummary(saved);
    }

    public List<UserSummaryDto> listAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toSummary)
                .collect(Collectors.toList());
    }

    private UserSummaryDto toSummary(User user) {
        return new UserSummaryDto(user.getId(), user.getName(), user.getEmail(), user.getRoles());
    }
}