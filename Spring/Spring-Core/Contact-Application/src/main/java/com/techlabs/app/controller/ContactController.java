package com.techlabs.app.controller;

import com.techlabs.app.dto.ContactRequestDTO;
import com.techlabs.app.dto.ContactResponseDTO;
import com.techlabs.app.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;

    @Operation(summary = "Get All contacts")
    @GetMapping
    public ResponseEntity<List<ContactResponseDTO>> getAllContacts(){
        logger.info("Fetching all contacts");
        List<ContactResponseDTO> contactResponseDTOS = contactService.getAllContacts();
        return new ResponseEntity<>(contactResponseDTOS, HttpStatus.OK);
    }

    @Operation(summary = "Get contact by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ContactResponseDTO> getContactById(@PathVariable(name = "id")Long id){
        logger.info("Fetching contact by ID : {}",id);
        ContactResponseDTO contactResponseDTO = contactService.getContactById(id);
        return new ResponseEntity<>(contactResponseDTO,HttpStatus.FOUND);
    }

    @Operation(summary = "Create new Contact")
    @PostMapping
    public ResponseEntity<ContactResponseDTO> createNewContact(
            @Valid @RequestBody ContactRequestDTO contactRequestDTO){
        logger.info("Creating new contact");
        ContactResponseDTO contactResponseDTO = contactService.createNewContact(contactRequestDTO);
        return new ResponseEntity<>(contactResponseDTO,HttpStatus.CREATED);
    }

    @Operation(summary = "Update contact")
    @PutMapping
    public ResponseEntity<ContactResponseDTO> updateContact(
            @Valid @RequestBody ContactRequestDTO contactRequestDTO){
        logger.info("Updating user with ID : {}",contactRequestDTO.getId());
        ContactResponseDTO contactResponseDTO = contactService.updateContact(contactRequestDTO);
        return new ResponseEntity<>(contactResponseDTO, HttpStatus.OK);
    }

    @Operation(summary = "Delete contact by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteContact(@PathVariable(name = "id")Long id){
        logger.info("Deleting contact with ID : {}",id);
        contactService.deleteContact(id);
        return ResponseEntity.ok("Deleted contact with ID : "+id);
    }

}
