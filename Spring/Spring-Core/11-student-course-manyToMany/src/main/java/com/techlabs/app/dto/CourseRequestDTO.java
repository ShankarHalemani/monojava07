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
public class CourseRequestDTO {
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String level;

    @NotNull
    private int credits;

    @NotNull
    private int enrollmentCap;

    private Set<StudentRequestDTO> studentRequests = new HashSet<>();

}
