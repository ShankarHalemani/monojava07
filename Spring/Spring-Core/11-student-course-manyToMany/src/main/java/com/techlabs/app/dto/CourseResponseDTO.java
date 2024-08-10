package com.techlabs.app.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class CourseResponseDTO {
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String level;

    @NotNull
    private int credits;

    @JsonBackReference
    private Set<StudentResponseDTO> studentResponses = new HashSet<>();
}
