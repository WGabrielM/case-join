package com.join.case_join.service;

import com.join.case_join.dto.UserDTO;
import com.join.case_join.model.User;
import com.join.case_join.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(@Valid UserDTO userDTO) {
        if (userRepository.existsByCpf(userDTO.getCpf())) {
            throw new IllegalArgumentException("CPF already registered");
        }
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }

        var user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return userRepository.save(user);
    }
} 