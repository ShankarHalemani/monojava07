package com.techlabs.app.service;

import com.techlabs.app.dto.ContactRequestDTO;
import com.techlabs.app.dto.ContactResponseDTO;
import com.techlabs.app.util.PagedResponse;

import java.util.List;

public interface ContactService {
    PagedResponse<ContactResponseDTO> getAllContacts(int page, int size, String sortBy, String direction);

    ContactResponseDTO getContactById(Long id);

    ContactResponseDTO createNewContact(ContactRequestDTO contactRequestDTO);

    ContactResponseDTO updateContact(ContactRequestDTO contactRequestDTO);

    void deleteContact(Long id);
}
