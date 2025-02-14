package com.join.case_join.service;

import com.join.case_join.dto.UserDTO;
import com.join.case_join.model.User;
import com.join.case_join.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final KafkaTemplate<String, User> kafkaTemplate;

    public UserService(UserRepository userRepository, 
                      KafkaTemplate<String, User> kafkaTemplate) {
        this.userRepository = userRepository;
        this.kafkaTemplate = kafkaTemplate;
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
        user = userRepository.save(user);
        
        
        kafkaTemplate.send("user-registration", user.getCpf(), user);
        
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }
} 