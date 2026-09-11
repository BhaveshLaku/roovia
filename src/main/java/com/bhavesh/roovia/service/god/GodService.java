package com.bhavesh.roovia.service.god;

import com.bhavesh.roovia.dto.god.UserSummaryDto;
import com.bhavesh.roovia.entity.enums.Role;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Set;

public interface GodService {

    public UserSummaryDto updateRoles(Long targetUserId, Set<Role> newRoles, Authentication actingAdmin);

    public List<UserSummaryDto> listAllUsers();
}
