package com.bhavesh.roovia.dto.god;

import com.bhavesh.roovia.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserSummaryDto {
    private Long id;
    private String name;
    private String email;
    private Set<Role> roles;

}