package com.bhavesh.roovia.repository;

import com.bhavesh.roovia.entity.Guest;
import com.bhavesh.roovia.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByUser(User user);
}