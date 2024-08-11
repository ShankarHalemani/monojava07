package com.techlabs.app.service;

import com.techlabs.app.dto.ContactRequestDTO;
import com.techlabs.app.dto.ContactResponseDTO;
import com.techlabs.app.entity.Contact;
import com.techlabs.app.entity.User;
import com.techlabs.app.exception.ContactRelatedException;
import com.techlabs.app.mapper.Mapper;
import com.techlabs.app.repository.ContactRepository;
import com.techlabs.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private Mapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ContactResponseDTO> getAllContacts() {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(currentUsername).get();
        List<Contact> contacts = user.getContacts();

        if(contacts.isEmpty()){
            logger.error("There are no contacts to be found for current user with ID : {}",user.getId());
            throw new ContactRelatedException("There are no contacts to be found for current user with ID : "+user.getId());
        }

        return mapper.getContactResponseList(contacts);
    }

    @Override
    public ContactResponseDTO getContactById(Long id) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(currentUsername).get();
        List<Contact> contacts = user.getContacts();

        Contact contact = contactRepository.findContactByIdAndIsActive(id,true).orElseThrow(() -> {
            logger.error("Contact with ID: {} is not active", id);
            return new ContactRelatedException("Contact with ID " + id + " is not active");
        });


        if(contacts.isEmpty()){
            logger.error("There are no contacts to be found for current user with ID : {}",user.getId());
            throw new ContactRelatedException("There are no contacts to be found for current user with ID : "+user.getId());
        }

        if(!contacts.contains(contact)){
            logger.error("There is no contact with ID : {} in contact list of user with ID : {}",id,user.getId());
            throw new ContactRelatedException("There is no contact with ID : "+id
                    +" in contact list of user with ID : " +user.getId());
        }

        return mapper.contactEntityToResponse(contact);
    }

    @Override
    public ContactResponseDTO createNewContact(ContactRequestDTO contactRequestDTO) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(currentUsername).orElseThrow(() -> {
            logger.error("User with username: {} not found", currentUsername);
            return new ContactRelatedException("User with username: " + currentUsername + " not found");
        });


        Contact contact = mapper.contactRequestToEntity(contactRequestDTO);

        contact.setUser(user);

        if (contactRepository.existsById(contact.getId())) {
            logger.error("Contact with ID : {} already exists", contact.getId());
            throw new ContactRelatedException("Contact already exists with ID " + contact.getId());
        }

        Contact newContact = contactRepository.save(contact);
        user.getContacts().add(newContact);
        userRepository.save(user);

        return mapper.contactEntityToResponse(newContact);
    }


    @Override
    public ContactResponseDTO updateContact(ContactRequestDTO contactRequestDTO) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(currentUsername).get();

        Contact contact = contactRepository.findById(contactRequestDTO.getId()).orElseThrow(() -> {
            logger.error("Contact with ID : {} does not exist", contactRequestDTO.getId());
            return new ContactRelatedException("Contact with ID " + contactRequestDTO.getId() + " does not exist");
        });

        if(!user.getContacts().contains(contact)){
            logger.error("There is no contact with ID : {} in contact list of user with ID : {}",contact.getId(),user.getId());
            throw new ContactRelatedException("There is no contact with ID : "+contact.getId()
                    +" in contact list of user with ID : " +user.getId());
        }

        contact.setId(contactRequestDTO.getId());
        contact.setFirstName(contactRequestDTO.getFirstName());
        contact.setLastName(contactRequestDTO.getLastName());
        contact.setIsActive(contactRequestDTO.getActive());

        return mapper.contactEntityToResponse(contactRepository.save(contact));
    }

    @Override
    public void deleteContact(Long id) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(currentUsername).get();

        Contact contact = contactRepository.findById(id).orElseThrow(()->{
            logger.error("There is no contact with ID : {}",id);
            return new ContactRelatedException("There is no contact with ID : "+id);
        });

        if(!user.getContacts().contains(contact)){
            logger.error("There is no contact with ID : {} in contact list of user with ID : {}",id,user.getId());
            throw new ContactRelatedException("There is no contact with ID : "+id
                    +" in contact list of user with ID : " +user.getId());
        }

        contact.setIsActive(false);
        contactRepository.save(contact);
    }
}
