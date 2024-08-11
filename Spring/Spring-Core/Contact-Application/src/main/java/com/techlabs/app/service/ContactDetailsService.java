package com.techlabs.app.service;

import com.techlabs.app.dto.ContactDetailsDTO;

import java.util.List;

public interface ContactDetailsService {
    List<ContactDetailsDTO> getAllContactDetailsOfContact(Long contactId);

    ContactDetailsDTO getContactDetailById(Long id);

    ContactDetailsDTO createNewContactDetail(Long id, ContactDetailsDTO contactDetailsDTO);

    ContactDetailsDTO updateContactDetail(Long id, ContactDetailsDTO contactDetailsDTO);

    void deleteContactDetail(Long id);
}
