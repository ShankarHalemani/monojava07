package com.techlabs.app.service;

import com.techlabs.app.dto.LoginDTO;
import com.techlabs.app.dto.RegisterDTO;
import com.techlabs.app.entity.Role;
import com.techlabs.app.entity.User;
import com.techlabs.app.exception.APIException;
import com.techlabs.app.repository.RoleRepository;
import com.techlabs.app.repository.UserRepository;
import com.techlabs.app.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(LoginDTO loginDTO) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    @Override
    public String register(RegisterDTO registerDTO, String newRole) {
        if(userRepository.existsUserByUsername(registerDTO.getUsername())){
            throw new APIException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        if(userRepository.existsUserByEmail(registerDTO.getEmail())){
            throw new APIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        User user = new User();
        user.setName(registerDTO.getName());
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(newRole).get();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);

        return "Uer Registered Successfully";

    }
}
