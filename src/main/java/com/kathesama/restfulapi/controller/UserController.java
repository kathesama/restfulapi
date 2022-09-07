package com.kathesama.restfulapi.controller;

import com.kathesama.restfulapi.model.request.UserDetailsRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${jms.configuration.base-url}/users")
public class UserController {

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>("get all users", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> creatUser(@RequestBody UserDetailsRequestModel user){
        return new ResponseEntity<>("add a user", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(){
        return new ResponseEntity<>("update a user", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> removeUser(){
        return new ResponseEntity<>("remove a user", HttpStatus.OK);
    }
}
