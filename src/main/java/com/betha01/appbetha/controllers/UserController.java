package com.betha01.appbetha.controllers;

import java.util.List;

import com.betha01.appbetha.models.Users;
import com.betha01.appbetha.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */

@RestController
@RequestMapping("users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public List < Users > list() {
      return userRepository.findAll();
  }

  @PostMapping
  public ResponseEntity<?> save(@RequestBody Users user) {

    user.setUserpass(new BCryptPasswordEncoder().encode(user.getUserpass()));
    
      return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(userRepository.saveAndFlush(user));
  }
    
  
}