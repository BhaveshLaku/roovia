package com.bhavesh.roovia.service.user;

import com.bhavesh.roovia.dto.user.ProfileUpdateRequestDto;
import com.bhavesh.roovia.dto.user.UserDto;
import com.bhavesh.roovia.entity.User;

public interface UserService {

    User getUserById(Long id);

    void updateProfile(ProfileUpdateRequestDto profileUpdateRequestDto);

    UserDto getMyProfile();
}
