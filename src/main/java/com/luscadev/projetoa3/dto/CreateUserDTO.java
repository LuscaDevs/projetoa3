package com.luscadev.projetoa3.dto;

import com.luscadev.projetoa3.model.Role;

public record CreateUserDTO(String email, String password, Role role) {

}