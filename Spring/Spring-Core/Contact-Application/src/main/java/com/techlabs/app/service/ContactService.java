package com.techlabs.app.service;

import com.techlabs.app.dto.ContactRequestDTO;
import com.techlabs.app.dto.ContactResponseDTO;

import java.util.List;

public interface ContactService {
    List<ContactResponseDTO> getAllContacts();

    ContactResponseDTO getContactById(Long id);

    ContactResponseDTO createNewContact(ContactRequestDTO contactRequestDTO);

    ContactResponseDTO updateContact(ContactRequestDTO contactRequestDTO);

    void deleteContact(Long id);
}
