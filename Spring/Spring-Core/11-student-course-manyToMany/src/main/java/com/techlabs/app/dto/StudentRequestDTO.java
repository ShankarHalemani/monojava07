package com.techlabs.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {
    private int id;

    @NotBlank
    private String name;

    @NotNull
    private double cgpa;

    @NotBlank
    private String major;

    @NotNull
    private long phoneNumber;

    private Set<CourseRequestDTO> courseRequests = new HashSet<>();

}
