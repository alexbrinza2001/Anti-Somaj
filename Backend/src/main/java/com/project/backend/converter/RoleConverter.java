package com.project.backend.converter;

import com.project.backend.dto.RoleDto;
import com.project.backend.entity.Role;

public class RoleConverter {
    public Role dtoToEntity(RoleDto roleDto){
        Role role = new Role();
        role.setName(roleDto.getName());
        return role;
    }

    public RoleDto entityToDto(Role role){
        RoleDto roleDto = new RoleDto();
        roleDto.setName(role.getName());
        return roleDto;
    }
}
