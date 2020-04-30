package com.betha01.appbetha.controllers;

import com.betha01.appbetha.models.Users;
import com.betha01.appbetha.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SessionController
 */

 @RestController
 @RequestMapping("oauth/token")
public class SessionController {

  @Autowired
  UserRepository userRepository;

  @PostMapping
  public ResponseEntity<?> Exist(@RequestBody Users user) { 
    
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(user);
  }

}