package com.techlabs.app.service;

import com.techlabs.app.dto.RegisterDTO;
import com.techlabs.app.dto.UserRequestDTO;
import com.techlabs.app.dto.UserResponseDTO;
import com.techlabs.app.util.PagedResponse;

import java.util.List;

public interface UserService {
    PagedResponse<UserResponseDTO> getAllUsers(int page, int size, String sortBy, String direction);

    UserResponseDTO getUserById(Long id);

    UserResponseDTO createNewUser(RegisterDTO registerDTO);

    UserResponseDTO updateUser(UserRequestDTO userRequestDTO);

    void deleteUser(Long id);
}
