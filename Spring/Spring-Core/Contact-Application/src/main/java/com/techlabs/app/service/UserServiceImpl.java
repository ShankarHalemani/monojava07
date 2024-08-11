package com.techlabs.app.service;

import com.techlabs.app.dto.RegisterDTO;
import com.techlabs.app.dto.UserRequestDTO;
import com.techlabs.app.dto.UserResponseDTO;
import com.techlabs.app.entity.Role;
import com.techlabs.app.entity.User;
import com.techlabs.app.exception.UserRelatedException;
import com.techlabs.app.mapper.Mapper;
import com.techlabs.app.repository.RoleRepository;
import com.techlabs.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mapper mapper;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAllUserByIsAdmin(false);
        if (users.isEmpty()) {
            logger.error("No users to be found");
            throw new UserRelatedException("No users to be found");
        }

        return mapper.getUserResponseList(users);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findByIdAndIsAdminAndActive(id,false,true).orElseThrow(() -> {
            logger.error("User with ID : {} not found", id);
            return new UserRelatedException("User with ID : " + id + " not found");
        });

        return mapper.userEntityToResponse(user);
    }

    @Override
    public UserResponseDTO createNewUser(RegisterDTO registerDTO) {
        User user = mapper.registerDTOToUser(registerDTO);
        user.setAdmin(false);
        user.setActive(true);
        user.setContacts(new ArrayList<>());

        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName("ROLE_STAFF").orElseThrow(() -> {
            logger.error("ROLE_STAFF not found");
            return new RuntimeException("Role conot be found");
        });

        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);

        return mapper.userEntityToResponse(user);
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(userRequestDTO.getId()).orElseThrow(()->{
            logger.error("User with ID : {} cannot be found",userRequestDTO.getId());
            return new UserRelatedException("User with ID : "+userRequestDTO.getId()+" cannot be found");
        });

        user.setActive(userRequestDTO.isActive());
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        userRepository.save(user);

        return mapper.userEntityToResponse(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->{
            logger.error("User with ID : {} cannot be found",id);
            return new UserRelatedException("User with ID : "+id+" cannot be found");
        });

        user.setActive(false);
        userRepository.save(user);
    }
}
