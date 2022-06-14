package com.project.backend.converter;

import com.project.backend.dto.UserDto;
import com.project.backend.entity.User;

public class UserConverter {

    public User dtoToEntity(UserDto userDto) {
        User user = new User();

        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());

        return user;
    }

    public UserDto entityToDto(User user) {
        UserDto userDto = new UserDto();
        FreelancerConverter freelancerConverter = new FreelancerConverter();
        EmployerConverter employerConverter = new EmployerConverter();

        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

}