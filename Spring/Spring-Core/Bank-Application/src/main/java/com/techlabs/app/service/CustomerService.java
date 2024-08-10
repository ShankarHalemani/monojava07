package com.techlabs.app.service;

import com.techlabs.app.dto.CustomerRequestDTO;
import com.techlabs.app.dto.CustomerResponseDTO;
import com.techlabs.app.dto.RegisterDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDTO> getAllCustomers();

    CustomerResponseDTO getCustomerById(long customerId);

    CustomerResponseDTO addNewCustomer(CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO);

    void deleteCustomer(long customerId);

    CustomerResponseDTO activateCustomer(CustomerRequestDTO customerRequestDTO);
}
