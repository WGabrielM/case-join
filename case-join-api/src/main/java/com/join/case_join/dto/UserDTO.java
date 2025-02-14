package com.join.case_join.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDTO {
    
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "CPF is required")
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF must be in format XXX.XXX.XXX-XX")
    private String cpf;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Telephone is required")
    private String telephone;
} 