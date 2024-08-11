package com.techlabs.app.mapper;

import com.techlabs.app.dto.*;
import com.techlabs.app.entity.Contact;
import com.techlabs.app.entity.ContactDetails;
import com.techlabs.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {
    @Autowired
    private PasswordEncoder passwordEncoder;


    public User registerDTOToUser(RegisterDTO registerDTO){
        User user = new User();
        user.setFirstName(registerDTO.getFirstName());
        user.setLastName(registerDTO.getLastName());
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        return user;
    }

    public User userRequestToEntity(UserRequestDTO userRequestDTO){

        User user = new User();
        user.setId(userRequestDTO.getId());
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setAdmin(false);
        user.setActive(userRequestDTO.isActive());

        return user;
    }

    public UserResponseDTO userEntityToResponse(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setFirstName(user.getFirstName());
        userResponseDTO.setLastName(user.getLastName());
        userResponseDTO.setActive(user.isActive());
        List<ContactResponseDTO> contactResponseDTOS = user.getContacts().stream()
                .map(contact -> contactEntityToResponse(contact)).toList();

        userResponseDTO.setContactResponseDTOS(contactResponseDTOS);

        return userResponseDTO;
    }

    public Contact contactRequestToEntity(ContactRequestDTO contactRequestDTO){
        Contact contact = new Contact();
        contact.setId(contactRequestDTO.getId());
        contact.setFirstName(contactRequestDTO.getFirstName());
        contact.setLastName(contactRequestDTO.getLastName());
        contact.setIsActive(contactRequestDTO.getActive());

        return contact;
    }

    public ContactResponseDTO contactEntityToResponse(Contact contact){
        ContactResponseDTO contactResponseDTO = new ContactResponseDTO();
        contactResponseDTO.setId(contact.getId());
        contactResponseDTO.setFirstName(contact.getFirstName());
        contactResponseDTO.setLastName(contact.getLastName());
        contactResponseDTO.setActive(contact.getIsActive());
        List<ContactDetailsDTO> contactDetailsDTOList = contact.getContactDetails().stream()
                .map(contactDetails -> contactDetailsEntityToDTO(contactDetails)).toList();

        contactResponseDTO.setContactDetailsDTOS(contactDetailsDTOList);

        return contactResponseDTO;
    }

    public ContactDetails contactDetailsDTOToEntity(ContactDetailsDTO contactDetailsDTO){
        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setId(contactDetailsDTO.getId());
        contactDetails.setType(contactDetailsDTO.getType());
        contactDetails.setValue(contactDetailsDTO.getValue());

        return contactDetails;
    }

    public ContactDetailsDTO contactDetailsEntityToDTO(ContactDetails contactDetails){
        ContactDetailsDTO contactDetailsDTO = new ContactDetailsDTO();
        contactDetailsDTO.setId(contactDetails.getId());
        contactDetailsDTO.setType(contactDetails.getType());
        contactDetailsDTO.setValue(contactDetails.getValue());

        return contactDetailsDTO;
    }

    public List<UserResponseDTO> getUserResponseList(List<User> users){
        List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
        for(User user : users){
            userResponseDTOS.add(userEntityToResponse(user));
        }

        return userResponseDTOS;
    }

    public List<ContactResponseDTO> getContactResponseList(List<Contact> contacts){
        List<ContactResponseDTO> contactResponseDTOS = new ArrayList<>();
        for(Contact contact : contacts){
            contactResponseDTOS.add(contactEntityToResponse(contact));
        }

        return contactResponseDTOS;
    }

    public List<ContactDetailsDTO> getContactDetailsDTOList(List<ContactDetails> contactDetails){
        List<ContactDetailsDTO> contactDetailsDTOS = new ArrayList<>();
        for (ContactDetails contactDetail : contactDetails){
            contactDetailsDTOS.add(contactDetailsEntityToDTO(contactDetail));
        }

        return contactDetailsDTOS;
    }
}
