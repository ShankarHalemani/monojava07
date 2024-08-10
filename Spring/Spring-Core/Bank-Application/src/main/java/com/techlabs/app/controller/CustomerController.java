package com.techlabs.app.controller;

import com.techlabs.app.dto.CustomerRequestDTO;
import com.techlabs.app.dto.CustomerResponseDTO;
import com.techlabs.app.service.CustomerService;
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
@RequestMapping("/api/customers")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @Operation(summary = "Get all customers")
    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        logger.info("Fetching all customers");
        List<CustomerResponseDTO> customerResponseDTOS = customerService.getAllCustomers();
        return new ResponseEntity<>(customerResponseDTOS, HttpStatus.OK);
    }

    @Operation(summary = "Get customer by ID")
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable(name = "customerId") long customerId) {
        logger.info("Fetching customer with ID: {}", customerId);
        CustomerResponseDTO customerResponseDTO = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerResponseDTO, HttpStatus.FOUND);
    }

    @Operation(summary = "Add a new customer")
    @PostMapping
    public ResponseEntity<CustomerResponseDTO> addNewCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
        logger.info("Adding new customer");
        CustomerResponseDTO customerResponseDTO = customerService.addNewCustomer(customerRequestDTO);
        return new ResponseEntity<>(customerResponseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Update customer details")
    @PutMapping
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
        logger.info("Updating customer details");
        CustomerResponseDTO customerResponseDTO = customerService.updateCustomer(customerRequestDTO);
        return new ResponseEntity<>(customerResponseDTO, HttpStatus.OK);
    }

    @Operation(summary = "Activate a customer")
    @PutMapping("/activate")
    public ResponseEntity<CustomerResponseDTO> activateCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
        logger.info("Activating customer");
        CustomerResponseDTO customerResponseDTO = customerService.activateCustomer(customerRequestDTO);
        return new ResponseEntity<>(customerResponseDTO, HttpStatus.OK);
    }

    @Operation(summary = "Delete a customer by ID")
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable(name = "customerId") long customerId) {
        logger.info("Deleting customer with ID: {}", customerId);
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Customer with ID: " + customerId + " deleted successfully");
    }
}
