package com.techlabs.app.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class StudentResponseDTO {
    private int id;

    @NotBlank
    private String name;

    @NotNull
    private double cgpa;

    @NotBlank
    private String major;

    @JsonManagedReference
    private Set<CourseResponseDTO> courseResponses = new HashSet<>();
}
