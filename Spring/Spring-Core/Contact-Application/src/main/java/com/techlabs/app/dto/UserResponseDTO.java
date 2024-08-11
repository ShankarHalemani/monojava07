package com.techlabs.app.dto;

import com.techlabs.app.entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private boolean active;

    private List<ContactResponseDTO> contactResponseDTOS;

}
