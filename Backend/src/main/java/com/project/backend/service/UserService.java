package com.project.backend.service;

import com.project.backend.converter.EmployerConverter;
import com.project.backend.converter.FreelancerConverter;
import com.project.backend.converter.UserConverter;
import com.project.backend.dto.UserDto;
import com.project.backend.entity.Employer;
import com.project.backend.entity.Freelancer;
import com.project.backend.entity.User;
import com.project.backend.repo.EmployerRepo;
import com.project.backend.repo.FreelancerRepo;
import com.project.backend.repo.RoleRepo;
import com.project.backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Component
public class UserService implements UserDetailsService {

    @Autowired
    UserRepo userRepository;

    @Autowired
    EmployerRepo employerRepository;

    @Autowired
    FreelancerRepo freelancerRepository;

    @Autowired
    RoleRepo roleRepo;

    public void addUser(UserDto userDto) {
        UserConverter userConverter = new UserConverter();
        FreelancerConverter freelancerConverter = new FreelancerConverter();
        EmployerConverter employerConverter = new EmployerConverter();

        String employerName = userDto.getEmployer().getName();
        employerRepository.save(employerConverter.dtoToEntity(userDto.getEmployer()));
        Employer employer = employerRepository.findByNameIs(employerName).get(0);

        String freelancerDescription = userDto.getFreelancer().getDescription();
        freelancerRepository.save(freelancerConverter.dtoToEntity(userDto.getFreelancer()));
        Freelancer freelancer = freelancerRepository.findByDescriptionIs(freelancerDescription).get(0);

        User user = userConverter.dtoToEntity(userDto);
        user.setEmployerId(employer.getEmployerId());
        user.setFreelancerId(freelancer.getFreelancerId());

        userRepository.save(user);
    }

    public List<UserDto> getUsers() {
        UserConverter userConverter = new UserConverter();
        EmployerConverter employerConverter = new EmployerConverter();
        FreelancerConverter freelancerConverter = new FreelancerConverter();

        List<User> userList = userRepository.findAll();
        List<UserDto> users = new ArrayList<UserDto>();

        for (User user : userList) {
            UserDto userDto = userConverter.entityToDto(user);
            try {
                userDto.setEmployer(employerConverter.entityToDto(employerRepository.getById(user.getEmployerId())));
                userDto.setFreelancer(freelancerConverter.entityToDto(freelancerRepository.getById(user.getFreelancerId())));
            } catch (Exception ignored) {

            };

            users.add(userDto);
        }

        return users;
    }

    public UserDto getUserById(Integer userId) {
        UserConverter userConverter = new UserConverter();

        try {
            return userConverter.entityToDto(userRepository.getById(userId));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found in database");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

}