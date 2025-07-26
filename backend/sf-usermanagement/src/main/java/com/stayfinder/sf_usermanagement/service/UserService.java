package com.stayfinder.sf_usermanagement.service;

import java.util.List;

import com.stayfinder.sf_usermanagement.dto.UpdateUserDTO;
import com.stayfinder.sf_usermanagement.dto.UserDTO;

public interface UserService {
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    UserDTO saveUser(UserDTO userDTO);  
    UserDTO updateUser(Long id, UpdateUserDTO updateDTO);
    void deleteUser(Long id);
}