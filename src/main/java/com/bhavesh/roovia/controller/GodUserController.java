package com.bhavesh.roovia.controller;

import com.bhavesh.roovia.dto.god.UpdateRolesDto;
import com.bhavesh.roovia.dto.god.UserSummaryDto;
import com.bhavesh.roovia.service.god.GodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/god")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class GodUserController {

    private final GodService godService;   // <-- final, and injected via constructor

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserSummaryDto>> listUsers() {
        return ResponseEntity.ok(godService.listAllUsers());
    }

    @PatchMapping("/{id}/roles")
    public ResponseEntity<UserSummaryDto> updateRoles(
            @PathVariable Long id,
            @RequestBody UpdateRolesDto dto,
            Authentication authentication
    ) {
        UserSummaryDto updated = godService.updateRoles(id, dto.getRoles(), authentication);
        return ResponseEntity.ok(updated);
    }
}