package com.project.backend.controller;

import com.project.backend.dto.UserDto;
import com.project.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);

        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> userList = userService.getUsers();

        return ResponseEntity.ok(userList);
    }

}
