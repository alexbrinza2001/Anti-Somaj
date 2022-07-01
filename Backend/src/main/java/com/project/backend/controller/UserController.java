package com.project.backend.controller;

import com.project.backend.dto.UserDto;
import com.project.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        if (userList.size() == 0) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        for (UserDto user : userList) {
            if (user.getPassword().length() < 10)
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

        return ResponseEntity.ok(userList);
    }

    @GetMapping("/user")
    @ResponseBody
    public ResponseEntity<UserDto> getUserById(@RequestParam(name = "id") Integer id) {
        UserDto userDto = userService.getUserById(id);

        if (userDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(userDto);
    }

}
