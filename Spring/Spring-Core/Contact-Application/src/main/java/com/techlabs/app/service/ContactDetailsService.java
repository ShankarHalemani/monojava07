package com.techlabs.app.service;

import com.techlabs.app.dto.ContactDetailsDTO;
import com.techlabs.app.util.PagedResponse;

import java.util.List;

public interface ContactDetailsService {
    PagedResponse<ContactDetailsDTO> getAllContactDetailsOfContact(Long contactId, int page, int size, String sortBy, String direction);

    ContactDetailsDTO getContactDetailById(Long id);

    ContactDetailsDTO createNewContactDetail(Long id, ContactDetailsDTO contactDetailsDTO);

    ContactDetailsDTO updateContactDetail(Long id, ContactDetailsDTO contactDetailsDTO);

    void deleteContactDetail(Long id);
}
