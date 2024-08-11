package com.techlabs.app.service;

import com.techlabs.app.dto.ContactDetailsDTO;
import com.techlabs.app.entity.Contact;
import com.techlabs.app.entity.ContactDetails;
import com.techlabs.app.entity.User;
import com.techlabs.app.exception.ContactDetailsRelatedException;
import com.techlabs.app.exception.ContactRelatedException;
import com.techlabs.app.mapper.Mapper;
import com.techlabs.app.repository.ContactDetailsRepository;
import com.techlabs.app.repository.ContactRepository;
import com.techlabs.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactDetailsSeviceImpl implements ContactDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(ContactDetailsSeviceImpl.class);

    @Autowired
    private ContactDetailsRepository contactDetailsRepository;

    @Autowired
    private Mapper mapper;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ContactDetailsDTO> getAllContactDetailsOfContact(Long id) {
        Contact contact = contactRepository.findContactByIdAndIsActive(id, true).orElseThrow(() -> {
            logger.error("Contact with ID: {} is not active", id);
            return new ContactRelatedException("Contact with ID " + id + " is not active");
        });

        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(currentUsername).get();

        if (!user.getContacts().contains(contact)) {
            logger.error("There is no contact with ID : {} in contact list of user with ID : {}", id, user.getId());
            throw new ContactRelatedException("There is no contact with ID : " + id
                    + " in contact list of user with ID : " + user.getId());
        }

        List<ContactDetails> contactDetails = contact.getContactDetails();

        return mapper.getContactDetailsDTOList(contactDetails);
    }

    @Override
    public ContactDetailsDTO getContactDetailById(Long id) {
        ContactDetails contactDetails = contactDetailsRepository.findById(id).orElseThrow(() -> {
            logger.error("Contact Detail with ID : {} not found", id);
            return new ContactDetailsRelatedException("Contact Detail with ID : " + id + " not found");
        });

        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(currentUsername).get();
        List<Contact> contacts = user.getContacts();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getContactDetails().contains(contactDetails)) {
                found = true;
            }
        }

        if (!found) {
            throw new ContactDetailsRelatedException("Contact detail with ID : "
                    + id + " does not belong to current user with ID : " + user.getId());
        }

        return mapper.contactDetailsEntityToDTO(contactDetails);
    }

    @Override
    public ContactDetailsDTO createNewContactDetail(Long id, ContactDetailsDTO contactDetailsDTO) {
        Contact contact = contactRepository.findContactByIdAndIsActive(id, true).orElseThrow(() -> {
            logger.error("Contact with ID: {} is not active", id);
            return new ContactRelatedException("Contact with ID " + id + " is not active");
        });

        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(currentUsername).get();

        if (!user.getContacts().contains(contact)) {
            logger.error("There is no contact with ID : {} in contact list of user with ID : {}", id, user.getId());
            throw new ContactRelatedException("There is no contact with ID : " + id
                    + " in contact list of user with ID : " + user.getId());
        }

        ContactDetails contactDetails = mapper.contactDetailsDTOToEntity(contactDetailsDTO);

        contactDetails.setContact(contact);

        if (contactDetailsRepository.existsById(contactDetails.getId())) {
            logger.error("Contact detail with ID : {} already exists", contactDetailsDTO.getId());
            throw new ContactDetailsRelatedException("Contact detail with ID : "
                    + contactDetails.getId() + " already exists");
        }

        ContactDetails newContactDetails = contactDetailsRepository.save(contactDetails);
        contact.getContactDetails().add(newContactDetails);
        contactRepository.save(contact);

        return mapper.contactDetailsEntityToDTO(newContactDetails);
    }

    @Override
    public ContactDetailsDTO updateContactDetail(Long id, ContactDetailsDTO contactDetailsDTO) {
        Contact contact = contactRepository.findContactByIdAndIsActive(id, true).orElseThrow(() -> {
            logger.error("Contact with ID: {} is not active", id);
            return new ContactRelatedException("Contact with ID " + id + " is not active");
        });

        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(currentUsername).get();

        if (!user.getContacts().contains(contact)) {
            logger.error("There is no contact with ID : {} in contact list of user with ID : {}", id, user.getId());
            throw new ContactRelatedException("There is no contact with ID : " + id
                    + " in contact list of user with ID : " + user.getId());
        }

        ContactDetails contactDetails = contactDetailsRepository.findById(contactDetailsDTO.getId())
                .orElseThrow(() -> {
                    logger.error("Contact Detail with ID : {} not found", contactDetailsDTO.getId());
                    return new ContactDetailsRelatedException("Contact Detail with ID : "
                            + contactDetailsDTO.getId() + " not found");
                });

        contactDetails.setId(contactDetailsDTO.getId());
        contactDetails.setType(contactDetailsDTO.getType());
        contactDetails.setValue(contactDetailsDTO.getValue());

        return mapper.contactDetailsEntityToDTO(contactDetailsRepository.save(contactDetails));

    }

    @Override
    public void deleteContactDetail(Long id) {
        ContactDetails contactDetails = contactDetailsRepository.findById(id).orElseThrow(() -> {
            logger.error("Contact Detail with ID : {} not found", id);
            return new ContactDetailsRelatedException("Contact Detail with ID : " + id + " not found");
        });

        Contact contact = contactDetails.getContact();

        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(currentUsername).get();

        if (!user.getContacts().contains(contact)) {
            logger.error("There is no contact with ID : {} in contact list of user with ID : {}", contact.getId(), user.getId());
            throw new ContactRelatedException("There is no contact with ID : " + contact.getId()
                    + " in contact list of user with ID : " + user.getId());
        }

        contact.getContactDetails().remove(contactDetails);
        contactDetailsRepository.delete(contactDetails);
        contactRepository.save(contact);
    }
}
