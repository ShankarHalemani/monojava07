package com.techlabs.app.controller;

import com.techlabs.app.dto.RegisterDTO;
import com.techlabs.app.dto.UserRequestDTO;
import com.techlabs.app.dto.UserResponseDTO;
import com.techlabs.app.service.UserService;
import com.techlabs.app.util.PagedResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Operation(summary = "Get All Users with pagination and sorting")
    @GetMapping
    public ResponseEntity<PagedResponse<UserResponseDTO>> getAllUsers(
            @RequestParam(name = "page", defaultValue = "0") @Min(0) int page,
            @RequestParam(name = "size", defaultValue = "2") @Min(1) int size,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "direction", defaultValue = "asc") String direction
    ) {
        logger.info("Fetching All Users with page: {}, size: {}, sortBy: {}, direction: {}", page, size, sortBy, direction);
        PagedResponse<UserResponseDTO> pagedResponse = userService.getAllUsers(page, size, sortBy, direction);
        return new ResponseEntity<>(pagedResponse, HttpStatus.OK);
    }


    @Operation(summary = "Get User by ID")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable(name = "id")Long id){
        logger.info("Fetching user by ID : {}",id);
        UserResponseDTO userResponseDTO = userService.getUserById(id);
        return new ResponseEntity<>(userResponseDTO,HttpStatus.FOUND);
    }

    @Operation(summary = "Create new User")
    @PostMapping
    public ResponseEntity<UserResponseDTO> createNewUser(@Valid @RequestBody RegisterDTO registerDTO){
        logger.info("Creating new User");
        UserResponseDTO userResponseDTO = userService.createNewUser(registerDTO);
        return new ResponseEntity<>(userResponseDTO,HttpStatus.CREATED);
    }

    @Operation(summary = "Update user")
    @PutMapping
    public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        logger.info("Updating user with ID : {}",userRequestDTO.getId());
        UserResponseDTO userResponseDTO = userService.updateUser(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO,HttpStatus.OK);
    }

    @Operation(summary = "Delete User by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(name = "id")Long id){
        logger.info("Deleting user by ID : {}",id);
        userService.deleteUser(id);

        return ResponseEntity.ok("User with ID : "+id+" deleted successfully");
    }
}
