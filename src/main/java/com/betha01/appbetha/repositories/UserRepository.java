package com.betha01.appbetha.repositories;

import com.betha01.appbetha.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */

 @Repository
public interface UserRepository extends JpaRepository<Users, Long> {
  Users findByUsername(String username);
}