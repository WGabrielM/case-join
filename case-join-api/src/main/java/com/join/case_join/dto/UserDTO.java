package com.join.case_join.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class UserDTO {
    
    @NotBlank(message = "Name is required")
    private String name;

    @CPF(message = "Invalid CPF")
    @NotBlank(message = "CPF is required")
    private String cpf;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Telephone is required")
    private String telephone;
} 