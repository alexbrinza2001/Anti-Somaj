package com.project.backend.converter;

import com.project.backend.dto.RoleDto;
import com.project.backend.dto.UserDto;
import com.project.backend.entity.Role;
import com.project.backend.entity.User;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

public class UserConverter {

    public User dtoToEntity(UserDto userDto) {
        User user = new User();
        RoleConverter roleConverter = new RoleConverter();
        Collection<Role> roles = new ArrayList<>();
        for(var u : userDto.getRoles()){
            roles.add(roleConverter.dtoToEntity(u));
        }
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setRoles(roles);

        return user;
    }

    public UserDto entityToDto(User user) {
        UserDto userDto = new UserDto();
        FreelancerConverter freelancerConverter = new FreelancerConverter();
        EmployerConverter employerConverter = new EmployerConverter();

        RoleConverter roleConverter = new RoleConverter();
        Collection<RoleDto> roles = new ArrayList<>();
        for(var u : user.getRoles()){
            roles.add(roleConverter.entityToDto(u));
        }

        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPassword(user.getPassword());
        userDto.setRoles(roles);

        return userDto;
    }

}