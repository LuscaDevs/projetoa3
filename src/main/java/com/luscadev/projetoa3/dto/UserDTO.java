package com.luscadev.projetoa3.dto;

import java.util.List;

import com.luscadev.projetoa3.model.Role;

public record UserDTO(Long id, String email, List<Role> roles) {

}