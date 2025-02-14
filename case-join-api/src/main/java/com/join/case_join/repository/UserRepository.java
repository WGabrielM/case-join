package com.join.case_join.repository;

import com.join.case_join.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    Optional<User> findByCpf(String cpf);
} 