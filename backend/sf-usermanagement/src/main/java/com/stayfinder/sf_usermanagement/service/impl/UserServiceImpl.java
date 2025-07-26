package com.stayfinder.sf_usermanagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stayfinder.sf_usermanagement.dto.UpdateUserDTO;
import com.stayfinder.sf_usermanagement.dto.UserDTO;
import com.stayfinder.sf_usermanagement.entity.User;
import com.stayfinder.sf_usermanagement.repository.UserRepository;
import com.stayfinder.sf_usermanagement.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
    private final UserRepository userRepository;

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userRepository.save(user);
        return toDTO(user);
    }

    @Override
    public UserDTO updateUser(Long id, UpdateUserDTO updateDTO) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(updateDTO.getName());
        user.setPhone(updateDTO.getPhone());
        userRepository.save(user);
        return toDTO(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO toDTO(User user) {
        return UserDTO.builder()
            .id(user.getId())
            .name(user.getName())
            .email(user.getEmail())
            .role(user.getRole())
            .phone(user.getPhone())
            .build();
    }
}