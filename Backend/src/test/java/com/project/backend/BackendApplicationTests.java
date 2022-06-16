package com.project.backend;

import com.project.backend.entity.Employer;
import com.project.backend.entity.Freelancer;
import com.project.backend.entity.Review;
import com.project.backend.entity.User;
import com.project.backend.repo.EmployerRepo;
import com.project.backend.repo.FreelancerRepo;
import com.project.backend.repo.ReviewRepo;
import com.project.backend.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BackendApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepo userRepository;

    @MockBean
    private FreelancerRepo freelancerRepo;

    @MockBean
    private EmployerRepo employerRepo;

    @MockBean
    private ReviewRepo reviewRepo;

    @Test
    @Transactional
    void testErrorWhenGetUsersEndpointIsNull() throws Exception {

        List<User> userList = new ArrayList<User>();

        Mockito.when(userRepository.findAll()).thenReturn(userList);

        mockMvc.perform(get("/users")).andExpect(status().isNotFound());

    }

    @Test
    @Transactional
    void checkPasswordTooShort() throws Exception {

        User user = new User();
        List <User> userList = new ArrayList<>();
        user.setPassword("123");
        user.setUserId(23);
        user.setEmployerId(75);
        user.setFreelancerId(97);
        userList.add(user);

        Mockito.when(userRepository.findAll()).thenReturn(userList);

        mockMvc.perform(get("/users")).andExpect(status().isExpectationFailed());
    }

    @Test
    @Transactional
    void checkDescriptionTooShort() throws Exception {

        Freelancer freelancer = new Freelancer();
        List <Freelancer> freelancerList = new ArrayList<>();
        freelancer.setDescription("Hello");
        freelancerList.add(freelancer);

        Mockito.when(freelancerRepo.findAll()).thenReturn(freelancerList);

        mockMvc.perform(get("/freelancers")).andExpect(status().isExpectationFailed());

    }

    @Test
    @Transactional
    void testGetUserByIdWithInvalidId() throws Exception {

        mockMvc.perform(get("/user?id=-1")).andExpect(status().isNotFound());

    }

    @Test
    @Transactional
    void testDeleteJobWithInvalidId() throws Exception {

        mockMvc.perform(delete("/job?id=-1")).andExpect(status().isNotFound());

    }

    @Test
    @Transactional
    void checkNameContainsNumber() throws Exception {

        Employer employer = new Employer();
        List <Employer> employerList = new ArrayList<>();
        employer.setName("lala1crt5tt");
        employerList.add(employer);

        Mockito.when(employerRepo.findAll()).thenReturn(employerList);

        mockMvc.perform(get("/employers")).andExpect(status().isExpectationFailed());
    }

    @Test
    @Transactional
    void checkRatingValue() throws Exception {

        Review review = new Review();
        List <Review> reviewList = new ArrayList<>();
        review.setRating(123);
        reviewList.add(review);

        Mockito.when(reviewRepo.findAll()).thenReturn(reviewList);

        mockMvc.perform(get("/reviews")).andExpect(status().isExpectationFailed());
    }

}
