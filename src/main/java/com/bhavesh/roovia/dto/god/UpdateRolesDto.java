package com.bhavesh.roovia.dto.god;

import com.bhavesh.roovia.entity.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UpdateRolesDto {
    private Set<Role> roles;

    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }
}