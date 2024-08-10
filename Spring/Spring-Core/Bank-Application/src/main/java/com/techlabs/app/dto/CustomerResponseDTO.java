package com.techlabs.app.dto;

import com.techlabs.app.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {

    private long id;

    private String firstName;

    private String lastName;

    private double totalBalance;

    private List<AccountResponseDTO> accounts;

    private boolean active;
}
