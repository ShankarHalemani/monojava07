package com.techlabs.app.controller;

import com.techlabs.app.dto.ContactDetailsDTO;
import com.techlabs.app.service.ContactDetailsService;
import com.techlabs.app.util.PagedResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactDetailsController {
    private static final Logger logger = LoggerFactory.getLogger(ContactDetailsController.class);

    @Autowired
    private ContactDetailsService contactDetailsService;

    @Operation(summary = "Get All Contact Details for a Contact with pagination and sorting")
    @GetMapping("/contacts/{contactId}/contactDetails")
    public ResponseEntity<PagedResponse<ContactDetailsDTO>> getAllContactDetailsOfContact(
            @PathVariable(name = "contactId") Long contactId,
            @RequestParam(name = "page", defaultValue = "0") @Min(0) int page,
            @RequestParam(name = "size", defaultValue = "10") @Min(1) int size,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "direction", defaultValue = "asc") String direction
    ) {
        logger.info("Fetching all contact details of contact with ID: {} with page: {}, size: {}, sortBy: {}, direction: {}", contactId, page, size, sortBy, direction);
        PagedResponse<ContactDetailsDTO> pagedResponse = contactDetailsService.getAllContactDetailsOfContact(contactId, page, size, sortBy, direction);
        return new ResponseEntity<>(pagedResponse, HttpStatus.OK);
    }


    @Operation(summary = "Get Contact Detail by ID")
    @GetMapping("/contact-details/{id}")
    public ResponseEntity<ContactDetailsDTO> getContactDetailById(@PathVariable(name = "id") Long id) {
        logger.info("Fetching contact detail by ID : {}", id);
        ContactDetailsDTO contactDetailsDTO = contactDetailsService.getContactDetailById(id);
        return new ResponseEntity<>(contactDetailsDTO, HttpStatus.FOUND);
    }

    @Operation(summary = "Create Contact Detail")
    @PostMapping("/contacts/{contactId}/details")
    public ResponseEntity<ContactDetailsDTO> createNewContactDetail(
            @PathVariable(name = "contactId") Long id,
            @RequestBody ContactDetailsDTO contactDetailsDTO) {
        logger.info("Creating contact detail for contact with ID : {}", id);
        ContactDetailsDTO contactDetailsDTO1 = contactDetailsService.createNewContactDetail(id, contactDetailsDTO);
        return new ResponseEntity<>(contactDetailsDTO1, HttpStatus.CREATED);
    }

    @Operation(summary = "Update Contact Detail")
    @PutMapping("/contact-details/{id}")
    public ResponseEntity<ContactDetailsDTO> updateContactDetail(
            @PathVariable(name = "id") Long id,
            @RequestBody ContactDetailsDTO contactDetailsDTO) {
        logger.info("Updating contact detail for contact with ID ; {}", id);
        ContactDetailsDTO contactDetailsDTO1 = contactDetailsService.updateContactDetail(id, contactDetailsDTO);
        return new ResponseEntity<>(contactDetailsDTO1, HttpStatus.OK);
    }

    @Operation(summary = "Delete Contact Detail")
    @DeleteMapping("/contact-details/{id}")
    public ResponseEntity<Object> deleteContactDetailById(@PathVariable(name = "id") Long id) {
        logger.info("Deleting contact detail with ID : {}", id);
        contactDetailsService.deleteContactDetail(id);
        return ResponseEntity.ok("Deleted contact detail with ID : " + id);
    }
}
